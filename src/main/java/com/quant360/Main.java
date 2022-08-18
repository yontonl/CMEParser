package com.quant360;

import com.quant360.mktdata.MessageHeaderDecoder;
import com.quant360.mktdata.SnapshotFullRefresh52Decoder;
import com.quant360.mktdata.SnapshotFullRefreshOrderBook53Decoder;
import org.agrona.concurrent.UnsafeBuffer;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try (PcapHandle handle = Pcaps.openOffline(
                "/home/ytliu/source/CMEParser/src/main/resources/sample-data/20220304.150000.160000.CME_GBX.NYMEX.75_18.A.04.pcap");
                PrintWriter fout = new PrintWriter(new FileOutputStream(
                        "/home/ytliu/source/CMEParser/src/main/resources/sample-data/20220304.150000.160000.CME_GBX.NYMEX.75_18.A.04.pcap.txt"))) {

            Packet packet;

            StringBuilder sb = new StringBuilder();
            while (null != (packet = handle.getNextPacket())) {
                byte[] rawData = packet.getPayload().getPayload().getPayload().getRawData();
                UnsafeBuffer buffer = new UnsafeBuffer(rawData);

                MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
                headerDecoder.wrap(buffer, 14);
                switch (headerDecoder.templateId()) {
                    case SnapshotFullRefreshOrderBook53Decoder.TEMPLATE_ID -> {
                        SnapshotFullRefreshOrderBook53Decoder decoder = new SnapshotFullRefreshOrderBook53Decoder();
                        decoder.wrapAndApplyHeader(buffer, 14, headerDecoder);
                        decoder.appendTo(sb);
                        sb.append('\n');
                    }
                    case SnapshotFullRefresh52Decoder.TEMPLATE_ID -> {
                        SnapshotFullRefresh52Decoder decoder = new SnapshotFullRefresh52Decoder();
                        decoder.wrapAndApplyHeader(buffer, 14, headerDecoder);
                        decoder.appendTo(sb);
                        sb.append('\n');
                    }
                }
                break;
            }
            System.out.println(sb);
//            fout.print(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}