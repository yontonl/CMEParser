package com.quant360.parser;

import com.quant360.sbe.codec.*;
import org.agrona.concurrent.UnsafeBuffer;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class IncrementalParser {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final String pcapFile;

    public IncrementalParser(String pcapFile) {
        this.pcapFile = pcapFile;
    }

    public void parse() {
        try (
                PcapHandle handle = Pcaps.openOffline(pcapFile);
                ) {
            ExecutorService executor = Executors.newCachedThreadPool();
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
        Map<String, String> packetFields = Map.of(
                "packet", String.valueOf(packetSeqNum),
                "timestamp", String.valueOf(timestamp),
                "sequence_number", String.valueOf(sequence_number),
                "sending_time", sending_time
        );

        while (offset < buffer.capacity()) {
            List<Map<String, String>> rowsOfMessage = new ArrayList<>();

            short messageLen = buffer.getShort(offset);
            offset += 2;

            MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
            headerDecoder.wrap(buffer, offset);
            offset += headerDecoder.encodedLength();

            Map<String, String> headerFields = Map.of(
                    "sbeTemplateId", String.valueOf(headerDecoder.templateId()),
                    "sbeSchemaId", String.valueOf(headerDecoder.schemaId()),
                    "sbeSchemaVersion", String.valueOf(headerDecoder.version()),
                    "sbeBlockLength", String.valueOf(headerDecoder.blockLength())
            );

            int templateId = headerDecoder.templateId();
            switch (templateId) {
                case MDIncrementalRefreshBook46Decoder.TEMPLATE_ID -> {
                    MDIncrementalRefreshBook46Decoder decoder = new MDIncrementalRefreshBook46Decoder();
                    decoder.wrap(buffer, offset, headerDecoder.blockLength(), headerDecoder.version());

                    Map<String, String> messageFixedFields = Map.of(
                            "TransactTime", String.valueOf(decoder.transactTime()),
                            "MatchEventIndicator", String.valueOf(decoder.matchEventIndicator())
                    );

                    var mdEntriesDecoder = decoder.noMDEntries();
                    if (mdEntriesDecoder.count() == 0) {
                        Map<String, String> row = new HashMap<>(packetFields);
                        row.putAll(headerFields);
                        row.putAll(messageFixedFields);
                        rowsOfMessage.add(row);
                        break;
                    }

                    List<Map<String, String>> mdEntries = new ArrayList<>();
                    for (var mdEntry : mdEntriesDecoder) {
                        mdEntries.add(Map.of(
                                "MDEntryPx", String.valueOf(mdEntry.mDEntryPx()),
                                "MDEntrySize", String.valueOf(mdEntry.mDEntrySize()),
                                "SecurityID", String.valueOf(mdEntry.securityID()),
                                "RptSeq", String.valueOf(mdEntry.rptSeq()),
                                "NumberOfOrders", String.valueOf(mdEntry.numberOfOrders()),
                                "MDPriceLevel", String.valueOf(mdEntry.mDPriceLevel()),
                                "MDUpdateAction", String.valueOf(mdEntry.mDUpdateAction()),
                                "MDEntryType", String.valueOf(mdEntry.mDEntryType())
                        ));
                    }

                    List<Map<String, String>> orderIDEntries = new ArrayList<>();
                    var orderIDEntryDecoder = decoder.noOrderIDEntries();
                    for (var orderIDEntry : orderIDEntryDecoder) {
                        orderIDEntries.add(Map.of(
                                "OrderID", String.valueOf(orderIDEntry.orderID()),
                                "MDOrderPriority", String.valueOf(orderIDEntry.mDOrderPriority()),
                                "MDDisplayQty", String.valueOf(orderIDEntry.mDDisplayQty()),
                                "ReferenceID", String.valueOf(orderIDEntry.referenceID()),
                                "OrderUpdateAction", String.valueOf(orderIDEntry.orderUpdateAction())
                        ));
                    }

                    for (int i = 0; i < mdEntries.size(); i++) {

                        int finalI = i;
                        List<Map<String, String>> subList
                                = orderIDEntries
                                    .stream()
                                    .filter(entry -> Integer.parseInt(entry.get("ReferenceID")) == finalI + 1)
                                    .toList();
                        if (subList.size() == 0) {
                            Map<String, String> row = new HashMap<>(packetFields);
                            row.putAll(headerFields);
                            row.putAll(messageFixedFields);
                            row.putAll(mdEntries.get(i));
                            row.putAll(Map.of("OrderID", "", "MDOrderPriority", "", "MDDisplayQty", "", "ReferenceID", "", "OrderUpdateAction", ""));
                            rowsOfMessage.add(row);
                        } else {
                            for (var entry : subList) {
                                Map<String, String> row = new HashMap<>(packetFields);
                                row.putAll(headerFields);
                                row.putAll(messageFixedFields);
                                row.putAll(mdEntries.get(i));
                                row.putAll(entry);
                                rowsOfMessage.add(row);
                            }
                        }
                    }
                }
                case MDIncrementalRefreshTradeSummary48Decoder.TEMPLATE_ID -> {
                    MDIncrementalRefreshTradeSummary48Decoder decoder = new MDIncrementalRefreshTradeSummary48Decoder();
                    decoder.wrap(buffer, offset, headerDecoder.blockLength(), headerDecoder.version());
                    Map<String, String> messageFixedFields = Map.of(
                            "TransactTime", String.valueOf(decoder.transactTime()),
                            "MatchEventIndicator", String.valueOf(decoder.matchEventIndicator())
                    );
                    var mdEntriesDecoder = decoder.noMDEntries();
                    if (mdEntriesDecoder.count() == 0) {
                        Map<String, String> row = new HashMap<>(packetFields);
                        row.putAll(headerFields);
                        row.putAll(messageFixedFields);
                        rowsOfMessage.add(row);
                        break;
                    }

                    List<Map<String, String>> mdEntries = new ArrayList<>();
                    for (var mdEntry : mdEntriesDecoder) {
                        mdEntries.add(Map.of(
                                "MDEntryPx", String.valueOf(mdEntry.mDEntryPx()),
                                "MDEntrySize", String.valueOf(mdEntry.mDEntrySize()),
                                "SecurityID", String.valueOf(mdEntry.securityID()),
                                "RptSeq", String.valueOf(mdEntry.rptSeq()),
                                "NumberOfOrders", String.valueOf(mdEntry.numberOfOrders()),
                                "AggressorSide", String.valueOf(mdEntry.aggressorSide()),
                                "MDUpdateAction", String.valueOf(mdEntry.mDUpdateAction()),
                                "MDEntryType", String.valueOf(mdEntry.mDEntryType()),
                                "MDTradeEntryID", String.valueOf(mdEntry.mDTradeEntryID())
                        ));
                    }

                    List<Map<String, String>> orderIDEntries = new ArrayList<>();
                    var orderIDEntryDecoder = decoder.noOrderIDEntries();
                    for (var orderIDEntry : orderIDEntryDecoder) {
                        orderIDEntries.add(Map.of(
                                "OrderID", String.valueOf(orderIDEntry.orderID()),
                                "LastQty", String.valueOf(orderIDEntry.lastQty())
                        ));
                    }

                    int orderIDIndex = 0;
                    for (var mdEntry : mdEntries) {
                        int numberOfOrders = Integer.parseInt(mdEntry.get("NumberOfOrders"));
                        if (numberOfOrders == 0) {
                            Map<String, String> row = new HashMap<>(packetFields);
                            row.putAll(headerFields);
                            row.putAll(messageFixedFields);
                            row.putAll(mdEntry);
                            row.putAll(Map.of("OrderID", "", "LastQty", ""));
                            rowsOfMessage.add(row);
                        } else {
                            for (var orderIDEntry : orderIDEntries.subList(orderIDIndex, orderIDIndex += numberOfOrders)) {
                                Map<String, String> row = new HashMap<>(packetFields);
                                row.putAll(headerFields);
                                row.putAll(messageFixedFields);
                                row.putAll(mdEntry);
                                row.putAll(orderIDEntry);
                                rowsOfMessage.add(row);
                            }
                        }
                    }
                }
                default -> { break; } // throw new IllegalStateException("Unknown templateId: " + templateId);
            }

            offset += messageLen;
            rowsOfPacket.addAll(rowsOfMessage);
        }

        return rowsOfPacket;
    }
}
