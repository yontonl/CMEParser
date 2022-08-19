/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    SnapshotFullRefresh52Encoder.NoMDEntriesEncoder.class})
/**
 * SnapshotFullRefresh
 */
@SuppressWarnings("all")
public final class SnapshotFullRefresh52Encoder implements MessageEncoderFlyweight
{
    public static final int BLOCK_LENGTH = 59;
    public static final int TEMPLATE_ID = 52;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final SnapshotFullRefresh52Encoder parentMessage = this;
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

    public SnapshotFullRefresh52Encoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public SnapshotFullRefresh52Encoder wrapAndApplyHeader(
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

    public SnapshotFullRefresh52Encoder lastMsgSeqNumProcessed(final long value)
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

    public SnapshotFullRefresh52Encoder totNumReports(final long value)
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

    public SnapshotFullRefresh52Encoder securityID(final int value)
    {
        buffer.putInt(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public SnapshotFullRefresh52Encoder rptSeq(final long value)
    {
        buffer.putInt(offset + 12, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public SnapshotFullRefresh52Encoder transactTime(final long value)
    {
        buffer.putLong(offset + 16, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
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

    public SnapshotFullRefresh52Encoder lastUpdateTime(final long value)
    {
        buffer.putLong(offset + 24, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
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

    public SnapshotFullRefresh52Encoder tradeDate(final int value)
    {
        buffer.putShort(offset + 32, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
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

    public SnapshotFullRefresh52Encoder mDSecurityTradingStatus(final SecurityTradingStatus value)
    {
        buffer.putByte(offset + 34, (byte)value.value());
        return this;
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

    private final PRICENULL9Encoder highLimitPrice = new PRICENULL9Encoder();

    /**
     * Upper price threshold for the instrument
     *
     * @return PRICENULL9Encoder : Upper price threshold for the instrument
     */
    public PRICENULL9Encoder highLimitPrice()
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
        return 9;
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

    private final PRICENULL9Encoder lowLimitPrice = new PRICENULL9Encoder();

    /**
     * Lower price threshold for the instrument
     *
     * @return PRICENULL9Encoder : Lower price threshold for the instrument
     */
    public PRICENULL9Encoder lowLimitPrice()
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
        return 9;
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

    private final PRICENULL9Encoder maxPriceVariation = new PRICENULL9Encoder();

    /**
     * Differential value for price banding
     *
     * @return PRICENULL9Encoder : Differential value for price banding
     */
    public PRICENULL9Encoder maxPriceVariation()
    {
        maxPriceVariation.wrap(buffer, offset + 51);
        return maxPriceVariation;
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
        private final SnapshotFullRefresh52Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoMDEntriesEncoder(final SnapshotFullRefresh52Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)22, java.nio.ByteOrder.LITTLE_ENDIAN);
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
            return 22;
        }

        public static int mDEntryPxId()
        {
            return 270;
        }

        public static int mDEntryPxSinceVersion()
        {
            return 9;
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

        private final PRICENULL9Encoder mDEntryPx = new PRICENULL9Encoder();

        /**
         * Market Data entry price
         *
         * @return PRICENULL9Encoder : Market Data entry price
         */
        public PRICENULL9Encoder mDEntryPx()
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

        public NoMDEntriesEncoder mDEntrySize(final int value)
        {
            buffer.putInt(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
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

        public NoMDEntriesEncoder numberOfOrders(final int value)
        {
            buffer.putInt(offset + 12, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
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

        public NoMDEntriesEncoder mDPriceLevel(final byte value)
        {
            buffer.putByte(offset + 16, value);
            return this;
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

        public NoMDEntriesEncoder tradingReferenceDate(final int value)
        {
            buffer.putShort(offset + 17, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
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

        public NoMDEntriesEncoder openCloseSettlFlag(final OpenCloseSettlFlag value)
        {
            buffer.putByte(offset + 19, (byte)value.value());
            return this;
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

        private final SettlPriceTypeEncoder settlPriceType = new SettlPriceTypeEncoder();

        /**
         * Bitmap field of eight Boolean type indicators representing settlement price type
         *
         * @return SettlPriceTypeEncoder : Bitmap field of eight Boolean type indicators representing settlement price type
         */
        public SettlPriceTypeEncoder settlPriceType()
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

        public NoMDEntriesEncoder mDEntryType(final MDEntryType value)
        {
            buffer.putByte(offset + 21, value.value());
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

        final SnapshotFullRefresh52Decoder decoder = new SnapshotFullRefresh52Decoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
