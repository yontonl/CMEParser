/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.mktdata;

import org.agrona.DirectBuffer;


/**
 * SnapshotFullRefresh
 */
@SuppressWarnings("all")
public final class SnapshotFullRefresh38Decoder
{
    public static final int BLOCK_LENGTH = 59;
    public static final int TEMPLATE_ID = 38;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final SnapshotFullRefresh38Decoder parentMessage = this;
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
        return "W";
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

    public SnapshotFullRefresh38Decoder wrap(
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

    public SnapshotFullRefresh38Decoder wrapAndApplyHeader(
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

    public SnapshotFullRefresh38Decoder sbeRewind()
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

    public long lastMsgSeqNumProcessed()
    {
        return (buffer.getInt(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

    public long totNumReports()
    {
        return (buffer.getInt(offset + 4, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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
        return buffer.getInt(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 12;
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
            return "SeqNum";
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
        return (buffer.getInt(offset + 12, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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
        return 16;
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
        return buffer.getLong(offset + 16, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int lastUpdateTimeId()
    {
        return 779;
    }

    public static int lastUpdateTimeSinceVersion()
    {
        return 0;
    }

    public static int lastUpdateTimeEncodingOffset()
    {
        return 24;
    }

    public static int lastUpdateTimeEncodingLength()
    {
        return 8;
    }

    public static String lastUpdateTimeMetaAttribute(final MetaAttribute metaAttribute)
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

    public static long lastUpdateTimeNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long lastUpdateTimeMinValue()
    {
        return 0x0L;
    }

    public static long lastUpdateTimeMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public long lastUpdateTime()
    {
        return buffer.getLong(offset + 24, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int tradeDateId()
    {
        return 75;
    }

    public static int tradeDateSinceVersion()
    {
        return 0;
    }

    public static int tradeDateEncodingOffset()
    {
        return 32;
    }

    public static int tradeDateEncodingLength()
    {
        return 2;
    }

    public static String tradeDateMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "optional";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "LocalMktDate";
        }

        return "";
    }

    public static int tradeDateNullValue()
    {
        return 65535;
    }

    public static int tradeDateMinValue()
    {
        return 0;
    }

    public static int tradeDateMaxValue()
    {
        return 65534;
    }

    public int tradeDate()
    {
        return (buffer.getShort(offset + 32, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }


    public static int mDSecurityTradingStatusId()
    {
        return 1682;
    }

    public static int mDSecurityTradingStatusSinceVersion()
    {
        return 0;
    }

    public static int mDSecurityTradingStatusEncodingOffset()
    {
        return 34;
    }

    public static int mDSecurityTradingStatusEncodingLength()
    {
        return 1;
    }

    public static String mDSecurityTradingStatusMetaAttribute(final MetaAttribute metaAttribute)
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

    public short mDSecurityTradingStatusRaw()
    {
        return ((short)(buffer.getByte(offset + 34) & 0xFF));
    }

    public SecurityTradingStatus mDSecurityTradingStatus()
    {
        return SecurityTradingStatus.get(((short)(buffer.getByte(offset + 34) & 0xFF)));
    }


    public static int highLimitPriceId()
    {
        return 1149;
    }

    public static int highLimitPriceSinceVersion()
    {
        return 0;
    }

    public static int highLimitPriceEncodingOffset()
    {
        return 35;
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

    private final PRICENULLDecoder highLimitPrice = new PRICENULLDecoder();

    /**
     * Upper price threshold for the instrument
     *
     * @return PRICENULLDecoder : Upper price threshold for the instrument
     */
    public PRICENULLDecoder highLimitPrice()
    {
        highLimitPrice.wrap(buffer, offset + 35);
        return highLimitPrice;
    }

    public static int lowLimitPriceId()
    {
        return 1148;
    }

    public static int lowLimitPriceSinceVersion()
    {
        return 0;
    }

    public static int lowLimitPriceEncodingOffset()
    {
        return 43;
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

    private final PRICENULLDecoder lowLimitPrice = new PRICENULLDecoder();

    /**
     * Lower price threshold for the instrument
     *
     * @return PRICENULLDecoder : Lower price threshold for the instrument
     */
    public PRICENULLDecoder lowLimitPrice()
    {
        lowLimitPrice.wrap(buffer, offset + 43);
        return lowLimitPrice;
    }

    public static int maxPriceVariationId()
    {
        return 1143;
    }

    public static int maxPriceVariationSinceVersion()
    {
        return 0;
    }

    public static int maxPriceVariationEncodingOffset()
    {
        return 51;
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

    private final PRICENULLDecoder maxPriceVariation = new PRICENULLDecoder();

    /**
     * Differential value for price banding
     *
     * @return PRICENULLDecoder : Differential value for price banding
     */
    public PRICENULLDecoder maxPriceVariation()
    {
        maxPriceVariation.wrap(buffer, offset + 51);
        return maxPriceVariation;
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
        private final SnapshotFullRefresh38Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoMDEntriesDecoder(final SnapshotFullRefresh38Decoder parentMessage)
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
            return 22;
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
            return 0;
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

        private final PRICENULLDecoder mDEntryPx = new PRICENULLDecoder();

        /**
         * Market Data entry price
         *
         * @return PRICENULLDecoder : Market Data entry price
         */
        public PRICENULLDecoder mDEntryPx()
        {
            mDEntryPx.wrap(buffer, offset + 0);
            return mDEntryPx;
        }

        public static int mDEntrySizeId()
        {
            return 271;
        }

        public static int mDEntrySizeSinceVersion()
        {
            return 0;
        }

        public static int mDEntrySizeEncodingOffset()
        {
            return 8;
        }

        public static int mDEntrySizeEncodingLength()
        {
            return 4;
        }

        public static String mDEntrySizeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "Qty";
            }

            return "";
        }

        public static int mDEntrySizeNullValue()
        {
            return 2147483647;
        }

        public static int mDEntrySizeMinValue()
        {
            return -2147483647;
        }

        public static int mDEntrySizeMaxValue()
        {
            return 2147483647;
        }

        public int mDEntrySize()
        {
            return buffer.getInt(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int numberOfOrdersId()
        {
            return 346;
        }

        public static int numberOfOrdersSinceVersion()
        {
            return 0;
        }

        public static int numberOfOrdersEncodingOffset()
        {
            return 12;
        }

        public static int numberOfOrdersEncodingLength()
        {
            return 4;
        }

        public static String numberOfOrdersMetaAttribute(final MetaAttribute metaAttribute)
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

        public static int numberOfOrdersNullValue()
        {
            return 2147483647;
        }

        public static int numberOfOrdersMinValue()
        {
            return -2147483647;
        }

        public static int numberOfOrdersMaxValue()
        {
            return 2147483647;
        }

        public int numberOfOrders()
        {
            return buffer.getInt(offset + 12, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int mDPriceLevelId()
        {
            return 1023;
        }

        public static int mDPriceLevelSinceVersion()
        {
            return 0;
        }

        public static int mDPriceLevelEncodingOffset()
        {
            return 16;
        }

        public static int mDPriceLevelEncodingLength()
        {
            return 1;
        }

        public static String mDPriceLevelMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte mDPriceLevelNullValue()
        {
            return (byte)127;
        }

        public static byte mDPriceLevelMinValue()
        {
            return (byte)-127;
        }

        public static byte mDPriceLevelMaxValue()
        {
            return (byte)127;
        }

        public byte mDPriceLevel()
        {
            return buffer.getByte(offset + 16);
        }


        public static int tradingReferenceDateId()
        {
            return 5796;
        }

        public static int tradingReferenceDateSinceVersion()
        {
            return 0;
        }

        public static int tradingReferenceDateEncodingOffset()
        {
            return 17;
        }

        public static int tradingReferenceDateEncodingLength()
        {
            return 2;
        }

        public static String tradingReferenceDateMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "LocalMktDate";
            }

            return "";
        }

        public static int tradingReferenceDateNullValue()
        {
            return 65535;
        }

        public static int tradingReferenceDateMinValue()
        {
            return 0;
        }

        public static int tradingReferenceDateMaxValue()
        {
            return 65534;
        }

        public int tradingReferenceDate()
        {
            return (buffer.getShort(offset + 17, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        }


        public static int openCloseSettlFlagId()
        {
            return 286;
        }

        public static int openCloseSettlFlagSinceVersion()
        {
            return 0;
        }

        public static int openCloseSettlFlagEncodingOffset()
        {
            return 19;
        }

        public static int openCloseSettlFlagEncodingLength()
        {
            return 1;
        }

        public static String openCloseSettlFlagMetaAttribute(final MetaAttribute metaAttribute)
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

        public short openCloseSettlFlagRaw()
        {
            return ((short)(buffer.getByte(offset + 19) & 0xFF));
        }

        public OpenCloseSettlFlag openCloseSettlFlag()
        {
            return OpenCloseSettlFlag.get(((short)(buffer.getByte(offset + 19) & 0xFF)));
        }


        public static int settlPriceTypeId()
        {
            return 731;
        }

        public static int settlPriceTypeSinceVersion()
        {
            return 0;
        }

        public static int settlPriceTypeEncodingOffset()
        {
            return 20;
        }

        public static int settlPriceTypeEncodingLength()
        {
            return 1;
        }

        public static String settlPriceTypeMetaAttribute(final MetaAttribute metaAttribute)
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

        private final SettlPriceTypeDecoder settlPriceType = new SettlPriceTypeDecoder();

        /**
         * Bitmap field of eight Boolean type indicators representing settlement price type
         *
         * @return SettlPriceTypeDecoder : Bitmap field of eight Boolean type indicators representing settlement price type
         */
        public SettlPriceTypeDecoder settlPriceType()
        {
            settlPriceType.wrap(buffer, offset + 20);
            return settlPriceType;
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
            return 21;
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

        public byte mDEntryTypeRaw()
        {
            return buffer.getByte(offset + 21);
        }

        public MDEntryType mDEntryType()
        {
            return MDEntryType.get(buffer.getByte(offset + 21));
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("mDEntryPx=");
            final PRICENULLDecoder mDEntryPx = mDEntryPx();
            if (mDEntryPx != null)
            {
                mDEntryPx.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append('|');
            builder.append("mDEntrySize=");
            builder.append(mDEntrySize());
            builder.append('|');
            builder.append("numberOfOrders=");
            builder.append(numberOfOrders());
            builder.append('|');
            builder.append("mDPriceLevel=");
            builder.append(mDPriceLevel());
            builder.append('|');
            builder.append("tradingReferenceDate=");
            builder.append(tradingReferenceDate());
            builder.append('|');
            builder.append("openCloseSettlFlag=");
            builder.append(openCloseSettlFlag());
            builder.append('|');
            builder.append("settlPriceType=");
            settlPriceType().appendTo(builder);
            builder.append('|');
            builder.append("mDEntryType=");
            builder.append(mDEntryType());
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

        final SnapshotFullRefresh38Decoder decoder = new SnapshotFullRefresh38Decoder();
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
        builder.append("[SnapshotFullRefresh38](sbeTemplateId=");
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
        builder.append("lastMsgSeqNumProcessed=");
        builder.append(lastMsgSeqNumProcessed());
        builder.append('|');
        builder.append("totNumReports=");
        builder.append(totNumReports());
        builder.append('|');
        builder.append("securityID=");
        builder.append(securityID());
        builder.append('|');
        builder.append("rptSeq=");
        builder.append(rptSeq());
        builder.append('|');
        builder.append("transactTime=");
        builder.append(transactTime());
        builder.append('|');
        builder.append("lastUpdateTime=");
        builder.append(lastUpdateTime());
        builder.append('|');
        builder.append("tradeDate=");
        builder.append(tradeDate());
        builder.append('|');
        builder.append("mDSecurityTradingStatus=");
        builder.append(mDSecurityTradingStatus());
        builder.append('|');
        builder.append("highLimitPrice=");
        final PRICENULLDecoder highLimitPrice = highLimitPrice();
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
        final PRICENULLDecoder lowLimitPrice = lowLimitPrice();
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
        final PRICENULLDecoder maxPriceVariation = maxPriceVariation();
        if (maxPriceVariation != null)
        {
            maxPriceVariation.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
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
    
    public SnapshotFullRefresh38Decoder sbeSkip()
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
