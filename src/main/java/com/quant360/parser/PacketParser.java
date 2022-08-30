package com.quant360.parser;

import com.quant360.sbe.codec.MessageHeaderDecoder;
import com.quant360.util.StrFmtUtil;
import org.agrona.concurrent.UnsafeBuffer;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public abstract class PacketParser {
    protected final String pcapFile;
    protected static Pattern FILENAME_PATTERN;

    public PacketParser(String pcapFile) {
        this.pcapFile = pcapFile;
    }

    public static Pattern filePattern() {
        return FILENAME_PATTERN;
    }

    public List<Message> parse() {
        List<Message> l = new ArrayList<>();
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

    protected List<Message> parsePacket(Packet packet) {
        List<Message> messages = new ArrayList<>();
        UnsafeBuffer buffer = new UnsafeBuffer(packet.getPayload().getPayload().getPayload().getRawData());

        int offset = 0;
        int sequence_number = buffer.getInt(offset);
        offset += 4;
        long sending_time = buffer.getLong(offset);
        String timestamp = new Date(sending_time / 1_000_000).toInstant().atOffset(ZoneOffset.ofHours(8)).format(StrFmtUtil.TIME_FORMATTER);
        offset += 8;

        Message packetFields = new Message();
        packetFields.timestamp = timestamp;
        packetFields.sequence_number = sequence_number;
        packetFields.sending_time = sending_time;

        while (offset < buffer.capacity()) {
            short messageLen = buffer.getShort(offset);

            MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
            messageHeaderDecoder.wrap(buffer, offset + 2);
            int templateId = messageHeaderDecoder.templateId();

            Message messageFields = new Message(packetFields);
            messageFields.sbeTemplateId = templateId;

            messages.addAll(parseMessage(buffer, offset, messageHeaderDecoder, messageFields, templateId));

            offset += messageLen;
        }
        return messages;
    }

    protected abstract List<Message> parseMessage(
            UnsafeBuffer buffer,
            int offset,
            MessageHeaderDecoder messageHeaderDecoder,
            Message messageFields,
            int templateId
    );
}
