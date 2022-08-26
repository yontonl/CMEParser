package com.quant360.parser;

import com.quant360.sbe.codec.*;
import org.agrona.concurrent.UnsafeBuffer;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class IncrementalParser {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final String pcapFile;

    public IncrementalParser(String pcapFile) {
        this.pcapFile = pcapFile;
    }

    public static void main(String[] args) {
        IncrementalParser parser = new IncrementalParser("src/main/resources/sample-data/20220303.220000.230000.CME_GBX.NYMEX.31_130.A.04.pcap.00000");
        parser.parse();
    }
    public void parse() {
        try (
                PcapHandle handle = Pcaps.openOffline(pcapFile)
                ) {
            Packet packet;
            int packetCount = 1;
            while ((packet = handle.getNextPacket()) != null) {
                List<Map<String, String>> rows = parsePacket(packet, packetCount++);
                System.out.println(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> task (List<Packet> packets) {
        return null;
    }

    public List<Map<String, String>> parsePacket(Packet packet, int packetSeqNum) {
        List<Map<String, String>> rowsOfPacket = new ArrayList<>();
        int offset = 0;

        byte[] rawData = packet.getPayload().getPayload().getPayload().getRawData();
        UnsafeBuffer buffer = new UnsafeBuffer(rawData);

        int sequence_number = buffer.getInt(offset);
        offset += 4;
        long timestamp = buffer.getLong(offset);
        offset += 8;

        String sending_time = sdf.format(new Date(timestamp));
        Map<String, String> packetFields = new HashMap<>();

        packetFields.put("packet", String.valueOf(packetSeqNum));
        packetFields.put("timestamp", String.valueOf(timestamp));
        packetFields.put("sequence_number", String.valueOf(sequence_number));
        packetFields.put("sending_time", sending_time);

        while (0 <= offset && offset < buffer.capacity()) {
            List<Map<String, String>> rowsOfMessage = new ArrayList<>();

            short messageLen = buffer.getShort(offset);

            MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
            headerDecoder.wrap(buffer, offset + 2);

            Map<String, String> headerFields = new HashMap<>();
            headerFields.put("sbeTemplateId", String.valueOf(headerDecoder.templateId()));
            headerFields.put("sbeSchemaId", String.valueOf(headerDecoder.schemaId()));
            headerFields.put("sbeSchemaVersion", String.valueOf(headerDecoder.version()));
            headerFields.put("sbeBlockLength", String.valueOf(headerDecoder.blockLength()));

            int templateId = headerDecoder.templateId();
            switch (templateId) {
                case MDIncrementalRefreshBook46Decoder.TEMPLATE_ID: {
                    MDIncrementalRefreshBook46Decoder decoder = new MDIncrementalRefreshBook46Decoder();
                    decoder.wrap(buffer, offset + 2 + headerDecoder.encodedLength(), headerDecoder.blockLength(), headerDecoder.version());

                    Map<String, String> messageFixedFields = new HashMap<>();
                    messageFixedFields.put("TransactTime", String.valueOf(decoder.transactTime()));
                    messageFixedFields.put("MatchEventIndicator", String.valueOf(decoder.matchEventIndicator()));

                    MDIncrementalRefreshBook46Decoder.NoMDEntriesDecoder mdEntriesDecoder = decoder.noMDEntries();
                    messageFixedFields.put("NoMDEntries", String.valueOf(mdEntriesDecoder.count()));

                    if (mdEntriesDecoder.count() == 0) {
                        Map<String, String> row = new HashMap<>(packetFields);
                        row.putAll(headerFields);
                        row.putAll(messageFixedFields);
                        rowsOfMessage.add(row);
                        break;
                    }

                    List<Map<String, String>> mdEntries = new ArrayList<>();
                    for (MDIncrementalRefreshBook46Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                        Map<String, String> entryMap = new HashMap<>();
                        entryMap.put("MDEntryPx", String.valueOf(mdEntry.mDEntryPx()));
                        entryMap.put("MDEntrySize", String.valueOf(mdEntry.mDEntrySize()));
                        entryMap.put("SecurityID", String.valueOf(mdEntry.securityID()));
                        entryMap.put("RptSeq", String.valueOf(mdEntry.rptSeq()));
                        entryMap.put("NumberOfOrders", String.valueOf(mdEntry.numberOfOrders()));
                        entryMap.put("MDPriceLevel", String.valueOf(mdEntry.mDPriceLevel()));
                        entryMap.put("MDUpdateAction", String.valueOf(mdEntry.mDUpdateAction()));
                        entryMap.put("MDEntryType", String.valueOf(mdEntry.mDEntryType()));
                        mdEntries.add(entryMap);
                    }

                    List<Map<String, String>> orderIDEntries = new ArrayList<>();
                    MDIncrementalRefreshBook46Decoder.NoOrderIDEntriesDecoder orderIDEntryDecoder = decoder.noOrderIDEntries();
                    messageFixedFields.put("NoOrderIDEntries", String.valueOf(orderIDEntryDecoder.count()));

                    for (MDIncrementalRefreshBook46Decoder.NoOrderIDEntriesDecoder orderIDEntry : orderIDEntryDecoder) {
                        Map<String, String> orderIDEntryMap = new HashMap<>();
                        orderIDEntryMap.put("OrderID", String.valueOf(orderIDEntry.orderID()));
                        orderIDEntryMap.put("MDOrderPriority", String.valueOf(orderIDEntry.mDOrderPriority()));
                        orderIDEntryMap.put("MDDisplayQty", String.valueOf(orderIDEntry.mDDisplayQty()));
                        orderIDEntryMap.put("ReferenceID", String.valueOf(orderIDEntry.referenceID()));
                        orderIDEntryMap.put("OrderUpdateAction", String.valueOf(orderIDEntry.orderUpdateAction()));
                        orderIDEntries.add(orderIDEntryMap);
                    }

                    for (int i = 0; i < mdEntries.size(); i++) {

                        int finalI = i;
                        List<Map<String, String>> subList
                                = orderIDEntries
                                    .stream()
                                    .filter(entry -> Integer.parseInt(entry.get("ReferenceID")) == finalI + 1)
                                    .collect(Collectors.toList());
                        if (subList.size() == 0) {
                            Map<String, String> row = new HashMap<>(packetFields);
                            row.putAll(headerFields);
                            row.putAll(messageFixedFields);
                            row.putAll(mdEntries.get(i));
                            row.put("OrderID", "");
                            row.put("MDOrderPriority", "");
                            row.put("MDDisplayQty", "");
                            row.put("ReferenceID", "");
                            row.put("OrderUpdateAction", "");
                            rowsOfMessage.add(row);
                        } else {
                            for (Map<String, String> entry : subList) {
                                Map<String, String> row = new HashMap<>(packetFields);
                                row.putAll(headerFields);
                                row.putAll(messageFixedFields);
                                row.putAll(mdEntries.get(i));
                                row.putAll(entry);
                                rowsOfMessage.add(row);
                            }
                        }
                    }
                    break;
                }
                case MDIncrementalRefreshTradeSummary48Decoder.TEMPLATE_ID: {
                    MDIncrementalRefreshTradeSummary48Decoder decoder = new MDIncrementalRefreshTradeSummary48Decoder();
                    decoder.wrap(buffer, offset + 2 + headerDecoder.encodedLength(), headerDecoder.blockLength(), headerDecoder.version());
                    Map<String, String> messageFixedFields = new HashMap<>();
                    messageFixedFields.put("TransactTime", String.valueOf(decoder.transactTime()));
                    messageFixedFields.put("MatchEventIndicator", String.valueOf(decoder.matchEventIndicator()));

                    MDIncrementalRefreshTradeSummary48Decoder.NoMDEntriesDecoder mdEntriesDecoder = decoder.noMDEntries();
                    messageFixedFields.put("NoMDEntries", String.valueOf(mdEntriesDecoder.count()));

                    if (mdEntriesDecoder.count() == 0) {
                        Map<String, String> row = new HashMap<>(packetFields);
                        row.putAll(headerFields);
                        row.putAll(messageFixedFields);
                        rowsOfMessage.add(row);
                        break;
                    }

                    List<Map<String, String>> mdEntries = new ArrayList<>();
                    for (MDIncrementalRefreshTradeSummary48Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                        Map<String, String> entryMap = new HashMap<>();
                        entryMap.put("MDEntryPx", String.valueOf(mdEntry.mDEntryPx()));
                        entryMap.put("MDEntrySize", String.valueOf(mdEntry.mDEntrySize()));
                        entryMap.put("SecurityID", String.valueOf(mdEntry.securityID()));
                        entryMap.put("RptSeq", String.valueOf(mdEntry.rptSeq()));
                        entryMap.put("NumberOfOrders", String.valueOf(mdEntry.numberOfOrders()));
                        entryMap.put("AggressorSide", String.valueOf(mdEntry.aggressorSide()));
                        entryMap.put("MDUpdateAction", String.valueOf(mdEntry.mDUpdateAction()));
                        entryMap.put("MDEntryType", String.valueOf(mdEntry.mDEntryType()));
                        entryMap.put("MDTradeEntryID", String.valueOf(mdEntry.mDTradeEntryID()));
                        mdEntries.add(entryMap);
                    }

                    List<Map<String, String>> orderIDEntries = new ArrayList<>();
                    MDIncrementalRefreshTradeSummary48Decoder.NoOrderIDEntriesDecoder orderIDEntryDecoder = decoder.noOrderIDEntries();
                    messageFixedFields.put("NoOrderIDEntries", String.valueOf(orderIDEntryDecoder.count()));

                    for (MDIncrementalRefreshTradeSummary48Decoder.NoOrderIDEntriesDecoder orderIDEntry : orderIDEntryDecoder) {
                        Map<String, String> orderIDEntryMap = new HashMap<>();
                        orderIDEntryMap.put("OrderID", String.valueOf(orderIDEntry.orderID()));
                        orderIDEntryMap.put("LastQty", String.valueOf(orderIDEntry.lastQty()));
                        orderIDEntries.add(orderIDEntryMap);
                    }

                    int orderIDIndex = 0;
                    for (Map<String, String> mdEntry : mdEntries) {
                        int numberOfOrders = Integer.parseInt(mdEntry.get("NumberOfOrders"));
                        if (numberOfOrders == 0 || orderIDEntries.size() == 0) {
                            Map<String, String> row = new HashMap<>(packetFields);
                            row.putAll(headerFields);
                            row.putAll(messageFixedFields);
                            row.putAll(mdEntry);
                            row.put("OrderID", "");
                            row.put("LastQty", "");
                            rowsOfMessage.add(row);
                        } else {
                            try {
                                for (Map<String, String> orderIDEntry : orderIDEntries.subList(orderIDIndex, orderIDIndex += numberOfOrders)) {
                                    Map<String, String> row = new HashMap<>(packetFields);
                                    row.putAll(headerFields);
                                    row.putAll(messageFixedFields);
                                    row.putAll(mdEntry);
                                    row.putAll(orderIDEntry);
                                    rowsOfMessage.add(row);
                                }
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                                System.out.println("packet = " + packet + ", packetSeqNum = " + packetSeqNum);
                                System.exit(1);
                            }
                        }
                    }
                    break;
                }
                default: { break; } // throw new IllegalStateException ("Unknown templateId: " + templateId);
            }

            offset += messageLen;
            rowsOfPacket.addAll(rowsOfMessage);
        }

        return rowsOfPacket;
    }
}
