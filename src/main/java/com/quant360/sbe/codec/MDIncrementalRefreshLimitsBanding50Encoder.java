/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    MDIncrementalRefreshLimitsBanding50Encoder.NoMDEntriesEncoder.class})
/**
 * MDIncrementalRefreshLimitsBanding
 */
@SuppressWarnings("all")
public final class MDIncrementalRefreshLimitsBanding50Encoder implements MessageEncoderFlyweight
{
    public static final int BLOCK_LENGTH = 11;
    public static final int TEMPLATE_ID = 50;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final MDIncrementalRefreshLimitsBanding50Encoder parentMessage = this;
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
        return "X";
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

    public MDIncrementalRefreshLimitsBanding50Encoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public MDIncrementalRefreshLimitsBanding50Encoder wrapAndApplyHeader(
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
        return 0;
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

    public MDIncrementalRefreshLimitsBanding50Encoder transactTime(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int matchEventIndicatorId()
    {
        return 5799;
    }

    public static int matchEventIndicatorSinceVersion()
    {
        return 0;
    }

    public static int matchEventIndicatorEncodingOffset()
    {
        return 8;
    }

    public static int matchEventIndicatorEncodingLength()
    {
        return 1;
    }

    public static String matchEventIndicatorMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "MultipleCharValue";
        }

        return "";
    }

    private final MatchEventIndicatorEncoder matchEventIndicator = new MatchEventIndicatorEncoder();

    /**
     * Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     *
     * @return MatchEventIndicatorEncoder : Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     */
    public MatchEventIndicatorEncoder matchEventIndicator()
    {
        matchEventIndicator.wrap(buffer, offset + 8);
        return matchEventIndicator;
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
        private final MDIncrementalRefreshLimitsBanding50Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoMDEntriesEncoder(final MDIncrementalRefreshLimitsBanding50Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)32, java.nio.ByteOrder.LITTLE_ENDIAN);
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
            return 32;
        }

        public static int highLimitPriceId()
        {
            return 1149;
        }

        public static int highLimitPriceSinceVersion()
        {
            return 9;
        }

        public static int highLimitPriceEncodingOffset()
        {
            return 0;
        }

        public static int highLimitPriceEncodingLength()
        {
            return 8;
        }

        public static String highLimitPriceMetaAttribute(final MetaAttribute metaAttribute)
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

        private final PRICENULL9Encoder highLimitPrice = new PRICENULL9Encoder();

        /**
         * Upper price threshold for the instrument
         *
         * @return PRICENULL9Encoder : Upper price threshold for the instrument
         */
        public PRICENULL9Encoder highLimitPrice()
        {
            highLimitPrice.wrap(buffer, offset + 0);
            return highLimitPrice;
        }

        public static int lowLimitPriceId()
        {
            return 1148;
        }

        public static int lowLimitPriceSinceVersion()
        {
            return 9;
        }

        public static int lowLimitPriceEncodingOffset()
        {
            return 8;
        }

        public static int lowLimitPriceEncodingLength()
        {
            return 8;
        }

        public static String lowLimitPriceMetaAttribute(final MetaAttribute metaAttribute)
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

        private final PRICENULL9Encoder lowLimitPrice = new PRICENULL9Encoder();

        /**
         * Lower price threshold for the instrument
         *
         * @return PRICENULL9Encoder : Lower price threshold for the instrument
         */
        public PRICENULL9Encoder lowLimitPrice()
        {
            lowLimitPrice.wrap(buffer, offset + 8);
            return lowLimitPrice;
        }

        public static int maxPriceVariationId()
        {
            return 1143;
        }

        public static int maxPriceVariationSinceVersion()
        {
            return 9;
        }

        public static int maxPriceVariationEncodingOffset()
        {
            return 16;
        }

        public static int maxPriceVariationEncodingLength()
        {
            return 8;
        }

        public static String maxPriceVariationMetaAttribute(final MetaAttribute metaAttribute)
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

        private final PRICENULL9Encoder maxPriceVariation = new PRICENULL9Encoder();

        /**
         * Differential static value for price banding
         *
         * @return PRICENULL9Encoder : Differential static value for price banding
         */
        public PRICENULL9Encoder maxPriceVariation()
        {
            maxPriceVariation.wrap(buffer, offset + 16);
            return maxPriceVariation;
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
            return 24;
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
                return "int";
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

        public NoMDEntriesEncoder securityID(final int value)
        {
            buffer.putInt(offset + 24, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int rptSeqId()
        {
            return 83;
        }

        public static int rptSeqSinceVersion()
        {
            return 0;
        }

        public static int rptSeqEncodingOffset()
        {
            return 28;
        }

        public static int rptSeqEncodingLength()
        {
            return 4;
        }

        public static String rptSeqMetaAttribute(final MetaAttribute metaAttribute)
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

        public static long rptSeqNullValue()
        {
            return 4294967295L;
        }

        public static long rptSeqMinValue()
        {
            return 0L;
        }

        public static long rptSeqMaxValue()
        {
            return 4294967294L;
        }

        public NoMDEntriesEncoder rptSeq(final long value)
        {
            buffer.putInt(offset + 28, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int mDUpdateActionId()
        {
            return 279;
        }

        public static int mDUpdateActionSinceVersion()
        {
            return 0;
        }

        public static int mDUpdateActionEncodingOffset()
        {
            return 32;
        }

        public static int mDUpdateActionEncodingLength()
        {
            return 0;
        }

        public static String mDUpdateActionMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "constant";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "int";
            }

            return "";
        }

        public static byte mDUpdateActionNullValue()
        {
            return (byte)-128;
        }

        public static byte mDUpdateActionMinValue()
        {
            return (byte)-127;
        }

        public static byte mDUpdateActionMaxValue()
        {
            return (byte)127;
        }

        public byte mDUpdateAction()
        {
            return (byte)0;
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
            return 32;
        }

        public static int mDEntryTypeEncodingLength()
        {
            return 0;
        }

        public static String mDEntryTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "constant";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "char";
            }

            return "";
        }

        public static byte mDEntryTypeNullValue()
        {
            return (byte)0;
        }

        public static byte mDEntryTypeMinValue()
        {
            return (byte)32;
        }

        public static byte mDEntryTypeMaxValue()
        {
            return (byte)126;
        }


        private static final byte[] MDENTRYTYPE_VALUE = { 103 };

        public static int mDEntryTypeLength()
        {
            return 1;
        }


        public byte mDEntryType(final int index)
        {
            return MDENTRYTYPE_VALUE[index];
        }

        public int getMDEntryType(final byte[] dst, final int offset, final int length)
        {
            final int bytesCopied = Math.min(length, 1);
            System.arraycopy(MDENTRYTYPE_VALUE, 0, dst, offset, bytesCopied);

            return bytesCopied;
        }

        public byte mDEntryType()
        {
            return (byte)103;
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

        final MDIncrementalRefreshLimitsBanding50Decoder decoder = new MDIncrementalRefreshLimitsBanding50Decoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
