package com.quant360.parser;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.quant360.sbe.codec.MessageHeaderDecoder;
import com.quant360.sbe.codec.SnapshotFullRefreshOrderBook53Decoder;
import com.quant360.util.StrFmtUtil;
import org.agrona.concurrent.UnsafeBuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class SnapshotParser extends PacketParser {
    public SnapshotParser(String pcapFile) {
        super(pcapFile);
    }
    public static final Pattern FILENAME_PATTERN = Pattern.compile(".*31_130\\.A.*");

    @Override
    public Pattern getFilenamePattern() {
        return FILENAME_PATTERN;
    }

    @JsonPropertyOrder({
            "timestamp", "sequence_number", "sending_time",
            "sbeTemplateId", "LastMsgSeqNumProcessed", "TotNumReports", "SecurityID", "NoChunks", "CurrentChunk", "TransactTime", "NoMDEntries",
            "OrderID", "MDOrderPriority", "MDEntryPx", "MDDisplayQty", "MDEntryType"
    })
    public static class Snapshot extends Message {
        public long LastMsgSeqNumProcessed;
        public long TotNumReports;
        public long SecurityID;
        public long NoChunks;
        public long CurrentChunk;
        public long TransactTime;
        public long NoMDEntries;
        public long OrderID;
        public long MDOrderPriority;
        public String MDEntryPx;
        public long MDDisplayQty;
        public String MDEntryType;

        public Snapshot(Snapshot other) {
            this.timestamp = other.timestamp;
            this.sequence_number = other.sequence_number;
            this.sending_time = other.sending_time;
            this.sbeTemplateId = other.sbeTemplateId;
            this.LastMsgSeqNumProcessed = other.LastMsgSeqNumProcessed;
            this.TotNumReports = other.TotNumReports;
            this.SecurityID = other.SecurityID;
            this.NoChunks = other.NoChunks;
            this.CurrentChunk = other.CurrentChunk;
            this.TransactTime = other.TransactTime;
            this.NoMDEntries = other.NoMDEntries;
            this.OrderID = other.OrderID;
            this.MDOrderPriority = other.MDOrderPriority;
            this.MDEntryPx = other.MDEntryPx;
            this.MDDisplayQty = other.MDDisplayQty;
            this.MDEntryType = other.MDEntryType;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Snapshot)) return false;

            Snapshot snapshot = (Snapshot) o;
            return this.timestamp.equals(snapshot.timestamp)
                    && this.sequence_number == snapshot.sequence_number
                    && this.sending_time == snapshot.sending_time
                    && this.sbeTemplateId == snapshot.sbeTemplateId
                    && this.LastMsgSeqNumProcessed == snapshot.LastMsgSeqNumProcessed
                    && this.TotNumReports == snapshot.TotNumReports
                    && this.SecurityID == snapshot.SecurityID
                    && this.NoChunks == snapshot.NoChunks
                    && this.CurrentChunk == snapshot.CurrentChunk
                    && this.TransactTime == snapshot.TransactTime
                    && this.NoMDEntries == snapshot.NoMDEntries
                    && this.OrderID == snapshot.OrderID
                    && this.MDOrderPriority == snapshot.MDOrderPriority
                    && Objects.equals(this.MDEntryPx, snapshot.MDEntryPx)
                    && this.MDDisplayQty == snapshot.MDDisplayQty
                    && Objects.equals(this.MDEntryType, snapshot.MDEntryType);
        }
    }

    @Override
    protected List<Message> parseMessage(UnsafeBuffer buffer, int offset, MessageHeaderDecoder messageHeaderDecoder, Message messageFields, int templateId) {
        List<Message> messages = new ArrayList<>();
        Snapshot snapshotMessageFields = (Snapshot) messageFields;
        if (templateId == SnapshotFullRefreshOrderBook53Decoder.TEMPLATE_ID) {
            SnapshotFullRefreshOrderBook53Decoder snapshotFullRefreshOrderBook53Decoder = new SnapshotFullRefreshOrderBook53Decoder();
            snapshotFullRefreshOrderBook53Decoder.wrap(buffer, offset + 2 + messageHeaderDecoder.encodedLength(), messageHeaderDecoder.blockLength(), messageHeaderDecoder.version());
            snapshotMessageFields.sbeTemplateId = templateId;
            snapshotMessageFields.LastMsgSeqNumProcessed = snapshotFullRefreshOrderBook53Decoder.lastMsgSeqNumProcessed();
            snapshotMessageFields.TotNumReports = snapshotFullRefreshOrderBook53Decoder.totNumReports();
            snapshotMessageFields.SecurityID = snapshotFullRefreshOrderBook53Decoder.securityID();
            snapshotMessageFields.NoChunks = snapshotFullRefreshOrderBook53Decoder.noChunks();
            snapshotMessageFields.CurrentChunk = snapshotFullRefreshOrderBook53Decoder.currentChunk();
            snapshotMessageFields.TransactTime = snapshotFullRefreshOrderBook53Decoder.transactTime();

            SnapshotFullRefreshOrderBook53Decoder.NoMDEntriesDecoder mdEntriesDecoder = snapshotFullRefreshOrderBook53Decoder.noMDEntries();
            snapshotMessageFields.NoMDEntries = mdEntriesDecoder.count();

            for (SnapshotFullRefreshOrderBook53Decoder.NoMDEntriesDecoder mdEntry : mdEntriesDecoder) {
                Snapshot mdEntryFields = new Snapshot(snapshotMessageFields);
                mdEntryFields.OrderID = mdEntry.orderID();
                mdEntryFields.MDOrderPriority = mdEntry.mDOrderPriority();
                mdEntryFields.MDEntryPx = StrFmtUtil.priceToString(Objects.requireNonNull(mdEntry.mDEntryPx()));
                mdEntryFields.MDDisplayQty = mdEntry.mDDisplayQty();
                mdEntryFields.MDEntryType = String.valueOf(mdEntry.mDEntryType());
                messages.add(mdEntryFields);
            }
        }

        return messages;
    }
}
