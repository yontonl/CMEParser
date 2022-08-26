package com.quant360.parser;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.agrona.concurrent.UnsafeBuffer;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

import java.io.FileOutputStream;
import java.util.*;
import java.text.SimpleDateFormat;

import com.quant360.sbe.codec.*;

public class MBOParser {
    private static String nullPriceToString(PRICENULL9Decoder price) {
        if (price.mantissa() == PRICENULL9Decoder.mantissaNullValue()) {
            return "null";
        }
        return String.format("%.1f", price.mantissa() * Math.pow(10, price.exponent()));
    }

    @JsonPropertyOrder({
            "packet", "timestamp", "sequence_number", "sending_time",
            "messagetype", "sbeTemplateId", "TransactTime", "MatchEventIndicator", "NoMDEntries",
            "OrderID", "MDOrderPriority", "MDEntryPx", "MDDisplayQty", "SecurityID", "MDUpdateAction", "MDEntryType"
    })
    public static class MBO {
        public String timestamp;
        public long sequence_number;
        public long sending_time;
        public String messagetype;
        public int sbeTemplateId;
        public long TransactTime;
        public String MatchEventIndicator;
        public int NoMDEntries;
        public long OrderID;
        public long MDOrderPriority;
        public String MDEntryPx;
        public int MDDisplayQty;
        public long SecurityID;
        public String MDUpdateAction;
        public String MDEntryType;

        public MBO() {}

        public MBO(String timestamp, long sequence_number, long sending_time, String messagetype, int sbeTemplateId, long transactTime, String matchEventIndicator, int noMDEntries, long orderID, long MDOrderPriority, String MDEntryPx, int MDDisplayQty, long securityID, String MDUpdateAction, String MDEntryType) {
            this.timestamp = timestamp;
            this.sequence_number = sequence_number;
            this.sending_time = sending_time;
            this.messagetype = messagetype;
            this.sbeTemplateId = sbeTemplateId;
            TransactTime = transactTime;
            MatchEventIndicator = matchEventIndicator;
            NoMDEntries = noMDEntries;
            OrderID = orderID;
            this.MDOrderPriority = MDOrderPriority;
            this.MDEntryPx = MDEntryPx;
            this.MDDisplayQty = MDDisplayQty;
            SecurityID = securityID;
            this.MDUpdateAction = MDUpdateAction;
            this.MDEntryType = MDEntryType;
        }

        public MBO(MBO other) {
            this.timestamp = other.timestamp;
            this.sequence_number = other.sequence_number;
            this.sending_time = other.sending_time;
            this.messagetype = other.messagetype;
            this.sbeTemplateId = other.sbeTemplateId;
            TransactTime = other.TransactTime;
            MatchEventIndicator = other.MatchEventIndicator;
            NoMDEntries = other.NoMDEntries;
            OrderID = other.OrderID;
            this.MDOrderPriority = other.MDOrderPriority;
            this.MDEntryPx = other.MDEntryPx;
            this.MDDisplayQty = other.MDDisplayQty;
            SecurityID = other.SecurityID;
            this.MDUpdateAction = other.MDUpdateAction;
            this.MDEntryType = other.MDEntryType;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MBO)) {
                return false;
            }
            MBO mbo = (MBO) o;
            return this.timestamp.equals(mbo.timestamp)
                    && this.sequence_number == mbo.sequence_number
                    && this.sending_time == mbo.sending_time
                    && this.messagetype.equals(mbo.messagetype)
                    && this.sbeTemplateId == mbo.sbeTemplateId
                    && this.TransactTime == mbo.TransactTime
                    && this.MatchEventIndicator.equals(mbo.MatchEventIndicator)
                    && this.NoMDEntries == mbo.NoMDEntries
                    && this.OrderID == mbo.OrderID
                    && this.MDOrderPriority == mbo.MDOrderPriority
                    && Objects.equals(this.MDEntryPx, mbo.MDEntryPx)
                    && this.MDDisplayQty == mbo.MDDisplayQty
                    && this.SecurityID == mbo.SecurityID
                    && this.MDUpdateAction.equals(mbo.MDUpdateAction)
                    && this.MDEntryType.equals(mbo.MDEntryType);
        }
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final String pcapFile;

    public MBOParser(String pcapFile) {
        this.pcapFile = pcapFile;
    }

    public List<MBO> parse() {
        List<MBO> l = new ArrayList<>();
        try (
                PcapHandle handle = Pcaps.openOffline(pcapFile)
                ) {
            Packet packet;
            while ((packet = handle.getNextPacket()) != null) {
                l.addAll(parsePacket(packet));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error parsing pcap file: " + pcapFile);
        }

        return l;
    }

    public List<MBO> parsePacket(Packet packet) {
        List<MBO> MBOs = new ArrayList<>();
        UnsafeBuffer buffer = new UnsafeBuffer(packet.getPayload().getPayload().getPayload().getRawData());

        int offset = 0;
        int sequence_number = buffer.getInt(offset);
        offset += 4;
        long sending_time = buffer.getLong(offset);
        String timestamp = sdf.format(new Date(sending_time / 1_000_000));
        offset += 8;

        MBO packetFields = new MBO();
        packetFields.timestamp = timestamp;
        packetFields.sequence_number = sequence_number;
        packetFields.sending_time = sending_time;

        while (offset < buffer.capacity()) {
            short messageLen = buffer.getShort(offset);

            MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
            messageHeaderDecoder.wrap(buffer, offset + 2);

            MBO messageFields = new MBO(packetFields);
            int templateId = messageHeaderDecoder.templateId();
            switch (templateId) {
                case MDIncrementalRefreshOrderBook47Decoder.TEMPLATE_ID: {
                    MDIncrementalRefreshOrderBook47Decoder mdIncrementalRefreshOrderBook47Decoder = new MDIncrementalRefreshOrderBook47Decoder();
                    mdIncrementalRefreshOrderBook47Decoder.wrap(buffer, offset + 2 + messageHeaderDecoder.encodedLength(), messageHeaderDecoder.blockLength(), messageHeaderDecoder.version());
                    messageFields.messagetype = "MDIncrementalRefreshOrderBook";
                    messageFields.sbeTemplateId = templateId;
                    messageFields.TransactTime = mdIncrementalRefreshOrderBook47Decoder.transactTime();
                    messageFields.MatchEventIndicator = String.valueOf(mdIncrementalRefreshOrderBook47Decoder.matchEventIndicator());

                    MDIncrementalRefreshOrderBook47Decoder.NoMDEntriesDecoder mdEntriesDecoder = mdIncrementalRefreshOrderBook47Decoder.noMDEntries();
                    messageFields.NoMDEntries = mdEntriesDecoder.count();

                    for (MDIncrementalRefreshOrderBook47Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                        MBO mdEntryFields = new MBO(messageFields);
                        mdEntryFields.OrderID = mdEntry.orderID();
                        mdEntryFields.MDOrderPriority = mdEntry.mDOrderPriority();
                        mdEntryFields.MDEntryPx = nullPriceToString(mdEntry.mDEntryPx());
                        mdEntryFields.MDDisplayQty = mdEntry.mDDisplayQty();
                        mdEntryFields.SecurityID = mdEntry.securityID();
                        mdEntryFields.MDUpdateAction = String.valueOf(mdEntry.mDUpdateAction());
                        mdEntryFields.MDEntryType = String.valueOf(mdEntry.mDEntryType());
                        MBOs.add(mdEntryFields);
                    }
                    break;
                }
                case MDIncrementalRefreshBook46Decoder.TEMPLATE_ID: {
                    MDIncrementalRefreshBook46Decoder mdIncrementalRefreshBook46Decoder = new MDIncrementalRefreshBook46Decoder();
                    mdIncrementalRefreshBook46Decoder.wrap(buffer, offset + 2 + messageHeaderDecoder.encodedLength(), messageHeaderDecoder.blockLength(), messageHeaderDecoder.version());
                    messageFields.messagetype = "MDIncrementalRefreshBook";
                    messageFields.sbeTemplateId = templateId;
                    messageFields.TransactTime = mdIncrementalRefreshBook46Decoder.transactTime();
                    messageFields.MatchEventIndicator = String.valueOf(mdIncrementalRefreshBook46Decoder.matchEventIndicator());

                    MDIncrementalRefreshBook46Decoder.NoMDEntriesDecoder mdEntriesDecoder = mdIncrementalRefreshBook46Decoder.noMDEntries();

                    List<MBO> mdEntries = new ArrayList<>();

                    for (MDIncrementalRefreshBook46Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                        MBO mdEntryFields = new MBO(messageFields);
                        mdEntryFields.MDEntryPx = nullPriceToString(mdEntry.mDEntryPx());
                        mdEntryFields.SecurityID = mdEntry.securityID();
                        mdEntryFields.MDEntryType = String.valueOf(mdEntry.mDEntryType());
                        mdEntries.add(mdEntryFields);
                    }

                    MDIncrementalRefreshBook46Decoder.NoOrderIDEntriesDecoder orderIDEntriesDecoder = mdIncrementalRefreshBook46Decoder.noOrderIDEntries();
                    for (MDIncrementalRefreshBook46Decoder.NoOrderIDEntriesDecoder orderIDEntry: orderIDEntriesDecoder) {
                        int referenceID = orderIDEntry.referenceID();
                        MBO orderIDEntryFields = new MBO(mdEntries.get(referenceID - 1));
                        orderIDEntryFields.OrderID = orderIDEntry.orderID();
                        orderIDEntryFields.MDOrderPriority = orderIDEntry.mDOrderPriority();
                        orderIDEntryFields.MDDisplayQty = orderIDEntry.mDDisplayQty();
                        orderIDEntryFields.MDUpdateAction = String.valueOf(orderIDEntry.orderUpdateAction());
                        orderIDEntryFields.NoMDEntries = orderIDEntriesDecoder.count();
                        MBOs.add(orderIDEntryFields);
                    }
                    break;
                }
            }

            offset += messageLen;
        }

        return MBOs;
    }

    public static void main(String[] args) {
        MBOParser parser = new MBOParser("src/main/resources/sample-data/20220817/20220816.220000.230000.CME_GBX.NYMEX.31_130.A.03.pcap.00000");
        List<MBO> l = parser.parse();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(MBO.class).withHeader();
        try (
                FileOutputStream fos = new FileOutputStream("src/main/resources/sample-data/20220817/20220816.220000.230000.CME_GBX.NYMEX.31_130.A.03.pcap.00000.csv");
                ) {
            mapper.writer(schema).writeValues(fos).writeAll(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}