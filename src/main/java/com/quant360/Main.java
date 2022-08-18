package com.quant360;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.quant360.mktdata.MessageHeaderDecoder;
import com.quant360.mktdata.SnapshotFullRefresh52Decoder;
import com.quant360.mktdata.SnapshotFullRefreshOrderBook53Decoder;
import org.agrona.concurrent.UnsafeBuffer;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;


import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try (
                PcapHandle handle = Pcaps.openOffline("src/main/resources/sample-data/20220304.150000.160000.CME_GBX.NYMEX.75_18.A.04.pcap");
                PrintWriter fout = new PrintWriter(new FileOutputStream("src/main/resources/sample-data/20220304.150000.160000.CME_GBX.NYMEX.75_18.A.04.SnapshotFullRefreshOrderBook.csv"))
        ) {

            Packet packet;

            int i = 1;
            List<HashMap<String, String>> messages = new ArrayList<>();

            while (null != (packet = handle.getNextPacket())) {
                byte[] rawData = packet.getPayload().getPayload().getPayload().getRawData();
                UnsafeBuffer buffer = new UnsafeBuffer(rawData);

                int sequence_number = buffer.getInt(0);
                long ts = buffer.getLong(4);
                Timestamp timestamp = new Timestamp(ts / 1_000_000);

                int offset = 14;
                MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
                HashMap<String, String> packetInitialMap = new HashMap<>();
                packetInitialMap.put("packet", String.valueOf(i++));
                packetInitialMap.put("timestamp", sdf.format(timestamp));
                packetInitialMap.put("sending_time", String.valueOf(ts));
                packetInitialMap.put("sequence_number", String.valueOf(sequence_number));

                while (offset < buffer.capacity()) {
                    headerDecoder.wrap(buffer, offset);
                    try {
                        switch (headerDecoder.templateId()) {
                            case SnapshotFullRefreshOrderBook53Decoder.TEMPLATE_ID -> {
                                SnapshotFullRefreshOrderBook53Decoder decoder = new SnapshotFullRefreshOrderBook53Decoder();
                                decoder.wrapAndApplyHeader(buffer, offset, headerDecoder);
                                var noMDEntries = decoder.noMDEntries();
                                HashMap<String, String> messageInitialMap = new HashMap<>(packetInitialMap);
                                messageInitialMap.put("sbeTemplateId", String.valueOf(headerDecoder.templateId()));
                                messageInitialMap.put("sbeSchemaId", String.valueOf(headerDecoder.schemaId()));
                                messageInitialMap.put("sbeSchemaVersion", String.valueOf(headerDecoder.version()));
                                messageInitialMap.put("sbeBlockLength", String.valueOf(headerDecoder.blockLength()));
                                messages.addAll(new Parser<
                                        SnapshotFullRefreshOrderBook53Decoder,
                                        SnapshotFullRefreshOrderBook53Decoder.NoMDEntriesDecoder
                                        >().parse(decoder, noMDEntries, messageInitialMap));
                                offset += (decoder.sbeBlockLength() + noMDEntries.count() * noMDEntries.actingBlockLength());
                            }
                            case SnapshotFullRefresh52Decoder.TEMPLATE_ID -> {
                                SnapshotFullRefresh52Decoder decoder = new SnapshotFullRefresh52Decoder();
                                decoder.wrapAndApplyHeader(buffer, offset, headerDecoder);
                                var noMDEntries = decoder.noMDEntries();
                                HashMap<String, String> messageInitialMap = new HashMap<>(packetInitialMap);
                                messageInitialMap.put("sbeTemplateId", String.valueOf(headerDecoder.templateId()));
                                messageInitialMap.put("sbeSchemaId", String.valueOf(headerDecoder.schemaId()));
                                messageInitialMap.put("sbeSchemaVersion", String.valueOf(headerDecoder.version()));
                                messageInitialMap.put("sbeBlockLength", String.valueOf(headerDecoder.blockLength()));
//                                messages.addAll(new Parser<
//                                        SnapshotFullRefresh52Decoder,
//                                        SnapshotFullRefresh52Decoder.NoMDEntriesDecoder
//                                        >().parse(decoder, noMDEntries, messageInitialMap));
                                offset += (decoder.sbeBlockLength() + noMDEntries.count() * noMDEntries.actingBlockLength());
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        break;
                    }
                    offset ++;
                }
            }

            CsvSchema.Builder schemaBuilder = CsvSchema.builder();
            schemaBuilder.addColumns(List.of(
                    "packet",
                    "timestamp",
                    "sequence_number",
                    "sending_time",
                    "sbeTemplateId",
                    "sbeSchemaId",
                    "sbeSchemaVersion",
                    "sbeBlockLength",
                    "lastMsgSeqNumProcessed",
                    "totNumReports",
                    "securityID",
                    "noChunks",
                    "currentChunk",
                    "transactTime",
                    "noMDEntries",
                    "orderID",
                    "mDOrderPriority",
                    "mDEntryPx",
                    "mDDisplayQty",
                    "mDEntryType"
            ), CsvSchema.ColumnType.STRING);
            CsvSchema schema = schemaBuilder.build().withHeader();
            CsvMapper mapper = new CsvMapper();
            mapper.writer(schema).writeValues(fout).writeAll(messages).flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}