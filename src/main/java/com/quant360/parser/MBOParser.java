package com.quant360.parser;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.quant360.sbe.codec.MDIncrementalRefreshBook46Decoder;
import com.quant360.sbe.codec.MDIncrementalRefreshOrderBook47Decoder;
import com.quant360.sbe.codec.MessageHeaderDecoder;
import com.quant360.util.StrFmtUtil;
import org.agrona.concurrent.UnsafeBuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class MBOParser extends PacketParser {
    public MBOParser(String pcapFile) {
        super(pcapFile);
    }
    public static final Pattern FILENAME_PATTERN = Pattern.compile(".*31_130\\.A.*\\.gz");

    @JsonPropertyOrder({
            "timestamp", "sequence_number", "sending_time",
            "messagetype", "sbeTemplateId", "TransactTime", "MatchEventIndicator", "NoMDEntries",
            "OrderID", "MDOrderPriority", "MDEntryPx", "MDDisplayQty", "SecurityID", "MDUpdateAction", "MDEntryType"
    })
    public static class MBO extends Message {
        public String messagetype;
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

        public MBO(Message message) {
            super(message);
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

    @Override
    protected List<Message> parseMessage(
            UnsafeBuffer buffer,
            int offset,
            MessageHeaderDecoder messageHeaderDecoder,
            Message messageFields,
            int templateId
    ) {
        MBO mboMessageFields = new MBO(messageFields);
        List<Message> messages = new ArrayList<>();

        switch (templateId) {
            case MDIncrementalRefreshOrderBook47Decoder.TEMPLATE_ID: {
                MDIncrementalRefreshOrderBook47Decoder mdIncrementalRefreshOrderBook47Decoder = new MDIncrementalRefreshOrderBook47Decoder();
                mdIncrementalRefreshOrderBook47Decoder.wrap(buffer, offset + 2 + messageHeaderDecoder.encodedLength(), messageHeaderDecoder.blockLength(), messageHeaderDecoder.version());

                mboMessageFields.messagetype = "MDIncrementalRefreshOrderBook";
                mboMessageFields.sbeTemplateId = templateId;
                mboMessageFields.TransactTime = mdIncrementalRefreshOrderBook47Decoder.transactTime();
                mboMessageFields.MatchEventIndicator = String.valueOf(mdIncrementalRefreshOrderBook47Decoder.matchEventIndicator());

                MDIncrementalRefreshOrderBook47Decoder.NoMDEntriesDecoder mdEntriesDecoder = mdIncrementalRefreshOrderBook47Decoder.noMDEntries();
                mboMessageFields.NoMDEntries = mdEntriesDecoder.count();

                for (MDIncrementalRefreshOrderBook47Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                    MBO mdEntryFields = new MBO(mboMessageFields);
                    mdEntryFields.OrderID = mdEntry.orderID();
                    mdEntryFields.MDOrderPriority = mdEntry.mDOrderPriority();
                    mdEntryFields.MDEntryPx = StrFmtUtil.nullPriceToString(Objects.requireNonNull(mdEntry.mDEntryPx()));
                    mdEntryFields.MDDisplayQty = mdEntry.mDDisplayQty();
                    mdEntryFields.SecurityID = mdEntry.securityID();
                    mdEntryFields.MDUpdateAction = String.valueOf(mdEntry.mDUpdateAction());
                    mdEntryFields.MDEntryType = String.valueOf(mdEntry.mDEntryType());
                    messages.add(mdEntryFields);
                }
            }
            case MDIncrementalRefreshBook46Decoder.TEMPLATE_ID: {
                MDIncrementalRefreshBook46Decoder mdIncrementalRefreshBook46Decoder = new MDIncrementalRefreshBook46Decoder();
                mdIncrementalRefreshBook46Decoder.wrap(buffer, offset + 2 + messageHeaderDecoder.encodedLength(), messageHeaderDecoder.blockLength(), messageHeaderDecoder.version());
                mboMessageFields.messagetype = "MDIncrementalRefreshBook";
                mboMessageFields.sbeTemplateId = templateId;
                mboMessageFields.TransactTime = mdIncrementalRefreshBook46Decoder.transactTime();
                mboMessageFields.MatchEventIndicator = String.valueOf(mdIncrementalRefreshBook46Decoder.matchEventIndicator());

                MDIncrementalRefreshBook46Decoder.NoMDEntriesDecoder mdEntriesDecoder = mdIncrementalRefreshBook46Decoder.noMDEntries();

                List<MBO> mdEntries = new ArrayList<>();

                for (MDIncrementalRefreshBook46Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                    MBO mdEntryFields = new MBO(mboMessageFields);
                    mdEntryFields.MDEntryPx = StrFmtUtil.nullPriceToString(Objects.requireNonNull(mdEntry.mDEntryPx()));
                    mdEntryFields.SecurityID = mdEntry.securityID();
                    mdEntryFields.MDEntryType = String.valueOf(mdEntry.mDEntryType());
                    mdEntries.add(mdEntryFields);
                }

                try {
                    MDIncrementalRefreshBook46Decoder.NoOrderIDEntriesDecoder orderIDEntriesDecoder = mdIncrementalRefreshBook46Decoder.noOrderIDEntries();
                    for (MDIncrementalRefreshBook46Decoder.NoOrderIDEntriesDecoder orderIDEntry: orderIDEntriesDecoder) {
                        int referenceID = orderIDEntry.referenceID();
                        MBO orderIDEntryFields = new MBO(mdEntries.get(referenceID - 1));
                        orderIDEntryFields.OrderID = orderIDEntry.orderID();
                        orderIDEntryFields.MDOrderPriority = orderIDEntry.mDOrderPriority();
                        orderIDEntryFields.MDDisplayQty = orderIDEntry.mDDisplayQty();
                        orderIDEntryFields.MDUpdateAction = String.valueOf(orderIDEntry.orderUpdateAction());
                        orderIDEntryFields.NoMDEntries = orderIDEntriesDecoder.count();
                        messages.add(orderIDEntryFields);
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
                break;
            }
        }
        return messages;
    }
}