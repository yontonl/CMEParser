/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.DirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    MDIncrementalRefreshLimitsBanding50Decoder.NoMDEntriesDecoder.class})
/**
 * MDIncrementalRefreshLimitsBanding
 */
@SuppressWarnings("all")
public final class MDIncrementalRefreshLimitsBanding50Decoder implements MessageDecoderFlyweight
{
    public static final int BLOCK_LENGTH = 11;
    public static final int TEMPLATE_ID = 50;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final MDIncrementalRefreshLimitsBanding50Decoder parentMessage = this;
    private DirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;
    int actingBlockLength;
    int actingVersion;

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

    public DirectBuffer buffer()
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

    public MDIncrementalRefreshLimitsBanding50Decoder wrap(
        final DirectBuffer buffer,
        final int offset,
        final int actingBlockLength,
        final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
    }

    public MDIncrementalRefreshLimitsBanding50Decoder wrapAndApplyHeader(
        final DirectBuffer buffer,
        final int offset,
        final MessageHeaderDecoder headerDecoder)
    {
        headerDecoder.wrap(buffer, offset);

        final int templateId = headerDecoder.templateId();
        if (TEMPLATE_ID != templateId)
        {
            throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
        }

        return wrap(
            buffer,
            offset + MessageHeaderDecoder.ENCODED_LENGTH,
            headerDecoder.blockLength(),
            headerDecoder.version());
    }

    public MDIncrementalRefreshLimitsBanding50Decoder sbeRewind()
    {
        return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
    }

    public int sbeDecodedLength()
    {
        final int currentLimit = limit();
        sbeSkip();
        final int decodedLength = encodedLength();
        limit(currentLimit);

        return decodedLength;
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

    public long transactTime()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    private final MatchEventIndicatorDecoder matchEventIndicator = new MatchEventIndicatorDecoder();

    /**
     * Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     *
     * @return MatchEventIndicatorDecoder : Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     */
    public MatchEventIndicatorDecoder matchEventIndicator()
    {
        matchEventIndicator.wrap(buffer, offset + 8);
        return matchEventIndicator;
    }

    private final NoMDEntriesDecoder noMDEntries = new NoMDEntriesDecoder(this);

    public static long noMDEntriesDecoderId()
    {
        return 268;
    }

    public static int noMDEntriesDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of entries in Market Data message
     *
     * @return NoMDEntriesDecoder : Number of entries in Market Data message
     */
    public NoMDEntriesDecoder noMDEntries()
    {
        noMDEntries.wrap(buffer);
        return noMDEntries;
    }

    /**
     * Number of entries in Market Data message
     */

    public static final class NoMDEntriesDecoder
        implements Iterable<NoMDEntriesDecoder>, java.util.Iterator<NoMDEntriesDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDIncrementalRefreshLimitsBanding50Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoMDEntriesDecoder(final MDIncrementalRefreshLimitsBanding50Decoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = 0;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = ((short)(buffer.getByte(limit + 2) & 0xFF));
        }

        public NoMDEntriesDecoder next()
        {
            if (index >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
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

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoMDEntriesDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return index < count;
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

        private final PRICENULL9Decoder highLimitPrice = new PRICENULL9Decoder();

        /**
         * Upper price threshold for the instrument
         *
         * @return PRICENULL9Decoder : Upper price threshold for the instrument
         */
        public PRICENULL9Decoder highLimitPrice()
        {
            if (parentMessage.actingVersion < 9)
            {
                return null;
            }

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

        private final PRICENULL9Decoder lowLimitPrice = new PRICENULL9Decoder();

        /**
         * Lower price threshold for the instrument
         *
         * @return PRICENULL9Decoder : Lower price threshold for the instrument
         */
        public PRICENULL9Decoder lowLimitPrice()
        {
            if (parentMessage.actingVersion < 9)
            {
                return null;
            }

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

        private final PRICENULL9Decoder maxPriceVariation = new PRICENULL9Decoder();

        /**
         * Differential static value for price banding
         *
         * @return PRICENULL9Decoder : Differential static value for price banding
         */
        public PRICENULL9Decoder maxPriceVariation()
        {
            if (parentMessage.actingVersion < 9)
            {
                return null;
            }

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

        public int securityID()
        {
            return buffer.getInt(offset + 24, java.nio.ByteOrder.LITTLE_ENDIAN);
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

        public long rptSeq()
        {
            return (buffer.getInt(offset + 28, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("highLimitPrice=");
            final PRICENULL9Decoder highLimitPrice = highLimitPrice();
            if (highLimitPrice != null)
            {
                highLimitPrice.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append('|');
            builder.append("lowLimitPrice=");
            final PRICENULL9Decoder lowLimitPrice = lowLimitPrice();
            if (lowLimitPrice != null)
            {
                lowLimitPrice.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append('|');
            builder.append("maxPriceVariation=");
            final PRICENULL9Decoder maxPriceVariation = maxPriceVariation();
            if (maxPriceVariation != null)
            {
                maxPriceVariation.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append('|');
            builder.append("securityID=");
            builder.append(securityID());
            builder.append('|');
            builder.append("rptSeq=");
            builder.append(rptSeq());
            builder.append('|');
            builder.append(')');

            return builder;
        }
        
        public NoMDEntriesDecoder sbeSkip()
        {

            return this;
        }
    }

    public String toString()
    {
        if (null == buffer)
        {
            return "";
        }

        final MDIncrementalRefreshLimitsBanding50Decoder decoder = new MDIncrementalRefreshLimitsBanding50Decoder();
        decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

        return decoder.appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final int originalLimit = limit();
        limit(initialOffset + actingBlockLength);
        builder.append("[MDIncrementalRefreshLimitsBanding50](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        builder.append("transactTime=");
        builder.append(transactTime());
        builder.append('|');
        builder.append("matchEventIndicator=");
        matchEventIndicator().appendTo(builder);
        builder.append('|');
        builder.append("noMDEntries=[");
        final int noMDEntriesOriginalOffset = noMDEntries.offset;
        final int noMDEntriesOriginalIndex = noMDEntries.index;
        final NoMDEntriesDecoder noMDEntries = noMDEntries();
        if (noMDEntries.count() > 0)
        {
            while (noMDEntries.hasNext())
            {
                noMDEntries.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noMDEntries.offset = noMDEntriesOriginalOffset;
        noMDEntries.index = noMDEntriesOriginalIndex;
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
    
    public MDIncrementalRefreshLimitsBanding50Decoder sbeSkip()
    {
        sbeRewind();
        NoMDEntriesDecoder noMDEntries = noMDEntries();
        if (noMDEntries.count() > 0)
        {
            while (noMDEntries.hasNext())
            {
                noMDEntries.next();
                noMDEntries.sbeSkip();
            }
        }

        return this;
    }
}
