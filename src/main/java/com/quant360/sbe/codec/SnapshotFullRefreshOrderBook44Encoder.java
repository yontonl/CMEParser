/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    SnapshotFullRefreshOrderBook44Encoder.NoMDEntriesEncoder.class})
/**
 * SnapshotFullRefreshOrderBook
 */
@SuppressWarnings("all")
public final class SnapshotFullRefreshOrderBook44Encoder implements MessageEncoderFlyweight
{
    public static final int BLOCK_LENGTH = 28;
    public static final int TEMPLATE_ID = 44;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final SnapshotFullRefreshOrderBook44Encoder parentMessage = this;
    private MutableDirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "W";
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int initialOffset()
    {
        return initialOffset;
    }

    public int offset()
    {
        return offset;
    }

    public SnapshotFullRefreshOrderBook44Encoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);

        return this;
    }

    public SnapshotFullRefreshOrderBook44Encoder wrapAndApplyHeader(
        final MutableDirectBuffer buffer, final int offset, final MessageHeaderEncoder headerEncoder)
    {
        headerEncoder
            .wrap(buffer, offset)
            .blockLength(BLOCK_LENGTH)
            .templateId(TEMPLATE_ID)
            .schemaId(SCHEMA_ID)
            .version(SCHEMA_VERSION);

        return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int lastMsgSeqNumProcessedId()
    {
        return 369;
    }

    public static int lastMsgSeqNumProcessedSinceVersion()
    {
        return 0;
    }

    public static int lastMsgSeqNumProcessedEncodingOffset()
    {
        return 0;
    }

    public static int lastMsgSeqNumProcessedEncodingLength()
    {
        return 4;
    }

    public static String lastMsgSeqNumProcessedMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "SeqNum";
        }

        return "";
    }

    public static long lastMsgSeqNumProcessedNullValue()
    {
        return 4294967295L;
    }

    public static long lastMsgSeqNumProcessedMinValue()
    {
        return 0L;
    }

    public static long lastMsgSeqNumProcessedMaxValue()
    {
        return 4294967294L;
    }

    public SnapshotFullRefreshOrderBook44Encoder lastMsgSeqNumProcessed(final long value)
    {
        buffer.putInt(offset + 0, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int totNumReportsId()
    {
        return 911;
    }

    public static int totNumReportsSinceVersion()
    {
        return 0;
    }

    public static int totNumReportsEncodingOffset()
    {
        return 4;
    }

    public static int totNumReportsEncodingLength()
    {
        return 4;
    }

    public static String totNumReportsMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "int";
        }

        return "";
    }

    public static long totNumReportsNullValue()
    {
        return 4294967295L;
    }

    public static long totNumReportsMinValue()
    {
        return 0L;
    }

    public static long totNumReportsMaxValue()
    {
        return 4294967294L;
    }

    public SnapshotFullRefreshOrderBook44Encoder totNumReports(final long value)
    {
        buffer.putInt(offset + 4, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int securityIDId()
    {
        return 48;
    }

    public static int securityIDSinceVersion()
    {
        return 0;
    }

    public static int securityIDEncodingOffset()
    {
        return 8;
    }

    public static int securityIDEncodingLength()
    {
        return 4;
    }

    public static String securityIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "String";
        }

        return "";
    }

    public static int securityIDNullValue()
    {
        return -2147483648;
    }

    public static int securityIDMinValue()
    {
        return -2147483647;
    }

    public static int securityIDMaxValue()
    {
        return 2147483647;
    }

    public SnapshotFullRefreshOrderBook44Encoder securityID(final int value)
    {
        buffer.putInt(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int noChunksId()
    {
        return 37709;
    }

    public static int noChunksSinceVersion()
    {
        return 0;
    }

    public static int noChunksEncodingOffset()
    {
        return 12;
    }

    public static int noChunksEncodingLength()
    {
        return 4;
    }

    public static String noChunksMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "int";
        }

        return "";
    }

    public static long noChunksNullValue()
    {
        return 4294967295L;
    }

    public static long noChunksMinValue()
    {
        return 0L;
    }

    public static long noChunksMaxValue()
    {
        return 4294967294L;
    }

    public SnapshotFullRefreshOrderBook44Encoder noChunks(final long value)
    {
        buffer.putInt(offset + 12, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int currentChunkId()
    {
        return 37710;
    }

    public static int currentChunkSinceVersion()
    {
        return 0;
    }

    public static int currentChunkEncodingOffset()
    {
        return 16;
    }

    public static int currentChunkEncodingLength()
    {
        return 4;
    }

    public static String currentChunkMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "int";
        }

        return "";
    }

    public static long currentChunkNullValue()
    {
        return 4294967295L;
    }

    public static long currentChunkMinValue()
    {
        return 0L;
    }

    public static long currentChunkMaxValue()
    {
        return 4294967294L;
    }

    public SnapshotFullRefreshOrderBook44Encoder currentChunk(final long value)
    {
        buffer.putInt(offset + 16, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int transactTimeId()
    {
        return 60;
    }

    public static int transactTimeSinceVersion()
    {
        return 0;
    }

    public static int transactTimeEncodingOffset()
    {
        return 20;
    }

    public static int transactTimeEncodingLength()
    {
        return 8;
    }

    public static String transactTimeMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "UTCTimestamp";
        }

        return "";
    }

    public static long transactTimeNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long transactTimeMinValue()
    {
        return 0x0L;
    }

    public static long transactTimeMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public SnapshotFullRefreshOrderBook44Encoder transactTime(final long value)
    {
        buffer.putLong(offset + 20, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    private final NoMDEntriesEncoder noMDEntries = new NoMDEntriesEncoder(this);

    public static long noMDEntriesId()
    {
        return 268;
    }

    /**
     * Number of entries in Market Data message
     *
     * @param count of times the group will be encoded.
     * @return NoMDEntriesEncoder : encoder for the group.
     */
    public NoMDEntriesEncoder noMDEntriesCount(final int count)
    {
        noMDEntries.wrap(buffer, count);
        return noMDEntries;
    }

    /**
     * Number of entries in Market Data message
     */

    public static final class NoMDEntriesEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final SnapshotFullRefreshOrderBook44Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoMDEntriesEncoder(final SnapshotFullRefreshOrderBook44Encoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final MutableDirectBuffer buffer, final int count)
        {
            if (count < 0 || count > 254)
            {
                throw new IllegalArgumentException("count outside allowed range: count=" + count);
            }

            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = 0;
            this.count = count;
            final int limit = parentMessage.limit();
            initialLimit = limit;
            parentMessage.limit(limit + HEADER_SIZE);
            buffer.putShort(limit + 0, (short)29, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoMDEntriesEncoder next()
        {
            if (index >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + sbeBlockLength());
            ++index;

            return this;
        }

        public int resetCountToIndex()
        {
            count = index;
            buffer.putByte(initialLimit + 2, (byte)count);

            return count;
        }

        public static short countMinValue()
        {
            return (short)0;
        }

        public static short countMaxValue()
        {
            return (short)254;
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 29;
        }

        public static int orderIDId()
        {
            return 37;
        }

        public static int orderIDSinceVersion()
        {
            return 0;
        }

        public static int orderIDEncodingOffset()
        {
            return 0;
        }

        public static int orderIDEncodingLength()
        {
            return 8;
        }

        public static String orderIDMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "int";
            }

            return "";
        }

        public static long orderIDNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long orderIDMinValue()
        {
            return 0x0L;
        }

        public static long orderIDMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public NoMDEntriesEncoder orderID(final long value)
        {
            buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int mDOrderPriorityId()
        {
            return 37707;
        }

        public static int mDOrderPrioritySinceVersion()
        {
            return 7;
        }

        public static int mDOrderPriorityEncodingOffset()
        {
            return 8;
        }

        public static int mDOrderPriorityEncodingLength()
        {
            return 8;
        }

        public static String mDOrderPriorityMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "int";
            }

            return "";
        }

        public static long mDOrderPriorityNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long mDOrderPriorityMinValue()
        {
            return 0x0L;
        }

        public static long mDOrderPriorityMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public NoMDEntriesEncoder mDOrderPriority(final long value)
        {
            buffer.putLong(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int mDEntryPxId()
        {
            return 270;
        }

        public static int mDEntryPxSinceVersion()
        {
            return 0;
        }

        public static int mDEntryPxEncodingOffset()
        {
            return 16;
        }

        public static int mDEntryPxEncodingLength()
        {
            return 8;
        }

        public static String mDEntryPxMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "Price";
            }

            return "";
        }

        private final PRICEEncoder mDEntryPx = new PRICEEncoder();

        /**
         * Order Price
         *
         * @return PRICEEncoder : Order Price
         */
        public PRICEEncoder mDEntryPx()
        {
            mDEntryPx.wrap(buffer, offset + 16);
            return mDEntryPx;
        }

        public static int mDDisplayQtyId()
        {
            return 37706;
        }

        public static int mDDisplayQtySinceVersion()
        {
            return 0;
        }

        public static int mDDisplayQtyEncodingOffset()
        {
            return 24;
        }

        public static int mDDisplayQtyEncodingLength()
        {
            return 4;
        }

        public static String mDDisplayQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "Qty";
            }

            return "";
        }

        public static int mDDisplayQtyNullValue()
        {
            return -2147483648;
        }

        public static int mDDisplayQtyMinValue()
        {
            return -2147483647;
        }

        public static int mDDisplayQtyMaxValue()
        {
            return 2147483647;
        }

        public NoMDEntriesEncoder mDDisplayQty(final int value)
        {
            buffer.putInt(offset + 24, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int mDEntryTypeId()
        {
            return 269;
        }

        public static int mDEntryTypeSinceVersion()
        {
            return 0;
        }

        public static int mDEntryTypeEncodingOffset()
        {
            return 28;
        }

        public static int mDEntryTypeEncodingLength()
        {
            return 1;
        }

        public static String mDEntryTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "char";
            }

            return "";
        }

        public NoMDEntriesEncoder mDEntryType(final MDEntryTypeBook value)
        {
            buffer.putByte(offset + 28, value.value());
            return this;
        }
    }

    public String toString()
    {
        if (null == buffer)
        {
            return "";
        }

        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final SnapshotFullRefreshOrderBook44Decoder decoder = new SnapshotFullRefreshOrderBook44Decoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
