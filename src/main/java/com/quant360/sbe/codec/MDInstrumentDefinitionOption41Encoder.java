/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    MDInstrumentDefinitionOption41Encoder.NoEventsEncoder.class,
    MDInstrumentDefinitionOption41Encoder.NoMDFeedTypesEncoder.class,
    MDInstrumentDefinitionOption41Encoder.NoInstAttribEncoder.class,
    MDInstrumentDefinitionOption41Encoder.NoLotTypeRulesEncoder.class,
    MDInstrumentDefinitionOption41Encoder.NoUnderlyingsEncoder.class,
    MDInstrumentDefinitionOption41Encoder.NoRelatedInstrumentsEncoder.class})
/**
 * MDInstrumentDefinitionOption
 */
@SuppressWarnings("all")
public final class MDInstrumentDefinitionOption41Encoder implements MessageEncoderFlyweight
{
    public static final int BLOCK_LENGTH = 213;
    public static final int TEMPLATE_ID = 41;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final MDInstrumentDefinitionOption41Encoder parentMessage = this;
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
        return "d";
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

    public MDInstrumentDefinitionOption41Encoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public MDInstrumentDefinitionOption41Encoder wrapAndApplyHeader(
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
        return 0;
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
        matchEventIndicator.wrap(buffer, offset + 0);
        return matchEventIndicator;
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
        return 1;
    }

    public static int totNumReportsEncodingLength()
    {
        return 4;
    }

    public static String totNumReportsMetaAttribute(final MetaAttribute metaAttribute)
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

    public MDInstrumentDefinitionOption41Encoder totNumReports(final long value)
    {
        buffer.putInt(offset + 1, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int securityUpdateActionId()
    {
        return 980;
    }

    public static int securityUpdateActionSinceVersion()
    {
        return 0;
    }

    public static int securityUpdateActionEncodingOffset()
    {
        return 5;
    }

    public static int securityUpdateActionEncodingLength()
    {
        return 1;
    }

    public static String securityUpdateActionMetaAttribute(final MetaAttribute metaAttribute)
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

    public MDInstrumentDefinitionOption41Encoder securityUpdateAction(final SecurityUpdateAction value)
    {
        buffer.putByte(offset + 5, value.value());
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
        return 6;
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

    public MDInstrumentDefinitionOption41Encoder lastUpdateTime(final long value)
    {
        buffer.putLong(offset + 6, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 14;
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

    public MDInstrumentDefinitionOption41Encoder mDSecurityTradingStatus(final SecurityTradingStatus value)
    {
        buffer.putByte(offset + 14, (byte)value.value());
        return this;
    }

    public static int applIDId()
    {
        return 1180;
    }

    public static int applIDSinceVersion()
    {
        return 0;
    }

    public static int applIDEncodingOffset()
    {
        return 15;
    }

    public static int applIDEncodingLength()
    {
        return 2;
    }

    public static String applIDMetaAttribute(final MetaAttribute metaAttribute)
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

    public static short applIDNullValue()
    {
        return (short)-32768;
    }

    public static short applIDMinValue()
    {
        return (short)-32767;
    }

    public static short applIDMaxValue()
    {
        return (short)32767;
    }

    public MDInstrumentDefinitionOption41Encoder applID(final short value)
    {
        buffer.putShort(offset + 15, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int marketSegmentIDId()
    {
        return 1300;
    }

    public static int marketSegmentIDSinceVersion()
    {
        return 0;
    }

    public static int marketSegmentIDEncodingOffset()
    {
        return 17;
    }

    public static int marketSegmentIDEncodingLength()
    {
        return 1;
    }

    public static String marketSegmentIDMetaAttribute(final MetaAttribute metaAttribute)
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

    public static short marketSegmentIDNullValue()
    {
        return (short)255;
    }

    public static short marketSegmentIDMinValue()
    {
        return (short)0;
    }

    public static short marketSegmentIDMaxValue()
    {
        return (short)254;
    }

    public MDInstrumentDefinitionOption41Encoder marketSegmentID(final short value)
    {
        buffer.putByte(offset + 17, (byte)value);
        return this;
    }


    public static int underlyingProductId()
    {
        return 462;
    }

    public static int underlyingProductSinceVersion()
    {
        return 0;
    }

    public static int underlyingProductEncodingOffset()
    {
        return 18;
    }

    public static int underlyingProductEncodingLength()
    {
        return 1;
    }

    public static String underlyingProductMetaAttribute(final MetaAttribute metaAttribute)
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

    public static short underlyingProductNullValue()
    {
        return (short)255;
    }

    public static short underlyingProductMinValue()
    {
        return (short)0;
    }

    public static short underlyingProductMaxValue()
    {
        return (short)254;
    }

    public MDInstrumentDefinitionOption41Encoder underlyingProduct(final short value)
    {
        buffer.putByte(offset + 18, (byte)value);
        return this;
    }


    public static int securityExchangeId()
    {
        return 207;
    }

    public static int securityExchangeSinceVersion()
    {
        return 0;
    }

    public static int securityExchangeEncodingOffset()
    {
        return 19;
    }

    public static int securityExchangeEncodingLength()
    {
        return 4;
    }

    public static String securityExchangeMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "Exchange";
        }

        return "";
    }

    public static byte securityExchangeNullValue()
    {
        return (byte)0;
    }

    public static byte securityExchangeMinValue()
    {
        return (byte)32;
    }

    public static byte securityExchangeMaxValue()
    {
        return (byte)126;
    }

    public static int securityExchangeLength()
    {
        return 4;
    }


    public MDInstrumentDefinitionOption41Encoder securityExchange(final int index, final byte value)
    {
        if (index < 0 || index >= 4)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 19 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }
    public MDInstrumentDefinitionOption41Encoder putSecurityExchange(final byte value0, final byte value1, final byte value2, final byte value3)
    {
        buffer.putByte(offset + 19, value0);
        buffer.putByte(offset + 20, value1);
        buffer.putByte(offset + 21, value2);
        buffer.putByte(offset + 22, value3);

        return this;
    }

    public static String securityExchangeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putSecurityExchange(final byte[] src, final int srcOffset)
    {
        final int length = 4;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 19, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder securityExchange(final String src)
    {
        final int length = 4;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 19, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 19 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder securityExchange(final CharSequence src)
    {
        final int length = 4;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 19, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 19 + start, (byte)0);
        }

        return this;
    }

    public static int securityGroupId()
    {
        return 1151;
    }

    public static int securityGroupSinceVersion()
    {
        return 0;
    }

    public static int securityGroupEncodingOffset()
    {
        return 23;
    }

    public static int securityGroupEncodingLength()
    {
        return 6;
    }

    public static String securityGroupMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte securityGroupNullValue()
    {
        return (byte)0;
    }

    public static byte securityGroupMinValue()
    {
        return (byte)32;
    }

    public static byte securityGroupMaxValue()
    {
        return (byte)126;
    }

    public static int securityGroupLength()
    {
        return 6;
    }


    public MDInstrumentDefinitionOption41Encoder securityGroup(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 23 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String securityGroupCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putSecurityGroup(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 23, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder securityGroup(final String src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 23, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 23 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder securityGroup(final CharSequence src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 23, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 23 + start, (byte)0);
        }

        return this;
    }

    public static int assetId()
    {
        return 6937;
    }

    public static int assetSinceVersion()
    {
        return 0;
    }

    public static int assetEncodingOffset()
    {
        return 29;
    }

    public static int assetEncodingLength()
    {
        return 6;
    }

    public static String assetMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte assetNullValue()
    {
        return (byte)0;
    }

    public static byte assetMinValue()
    {
        return (byte)32;
    }

    public static byte assetMaxValue()
    {
        return (byte)126;
    }

    public static int assetLength()
    {
        return 6;
    }


    public MDInstrumentDefinitionOption41Encoder asset(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 29 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String assetCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putAsset(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 29, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder asset(final String src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 29, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 29 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder asset(final CharSequence src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 29, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 29 + start, (byte)0);
        }

        return this;
    }

    public static int symbolId()
    {
        return 55;
    }

    public static int symbolSinceVersion()
    {
        return 0;
    }

    public static int symbolEncodingOffset()
    {
        return 35;
    }

    public static int symbolEncodingLength()
    {
        return 20;
    }

    public static String symbolMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte symbolNullValue()
    {
        return (byte)0;
    }

    public static byte symbolMinValue()
    {
        return (byte)32;
    }

    public static byte symbolMaxValue()
    {
        return (byte)126;
    }

    public static int symbolLength()
    {
        return 20;
    }


    public MDInstrumentDefinitionOption41Encoder symbol(final int index, final byte value)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 35 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String symbolCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putSymbol(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 35, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder symbol(final String src)
    {
        final int length = 20;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 35, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 35 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder symbol(final CharSequence src)
    {
        final int length = 20;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 35, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 35 + start, (byte)0);
        }

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
        return 55;
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

    public MDInstrumentDefinitionOption41Encoder securityID(final int value)
    {
        buffer.putInt(offset + 55, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int securityIDSourceId()
    {
        return 22;
    }

    public static int securityIDSourceSinceVersion()
    {
        return 0;
    }

    public static int securityIDSourceEncodingOffset()
    {
        return 59;
    }

    public static int securityIDSourceEncodingLength()
    {
        return 0;
    }

    public static String securityIDSourceMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte securityIDSourceNullValue()
    {
        return (byte)0;
    }

    public static byte securityIDSourceMinValue()
    {
        return (byte)32;
    }

    public static byte securityIDSourceMaxValue()
    {
        return (byte)126;
    }


    private static final byte[] SECURITYIDSOURCE_VALUE = { 56 };

    public static int securityIDSourceLength()
    {
        return 1;
    }


    public byte securityIDSource(final int index)
    {
        return SECURITYIDSOURCE_VALUE[index];
    }

    public int getSecurityIDSource(final byte[] dst, final int offset, final int length)
    {
        final int bytesCopied = Math.min(length, 1);
        System.arraycopy(SECURITYIDSOURCE_VALUE, 0, dst, offset, bytesCopied);

        return bytesCopied;
    }

    public byte securityIDSource()
    {
        return (byte)56;
    }


    public static int securityTypeId()
    {
        return 167;
    }

    public static int securityTypeSinceVersion()
    {
        return 0;
    }

    public static int securityTypeEncodingOffset()
    {
        return 59;
    }

    public static int securityTypeEncodingLength()
    {
        return 6;
    }

    public static String securityTypeMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte securityTypeNullValue()
    {
        return (byte)0;
    }

    public static byte securityTypeMinValue()
    {
        return (byte)32;
    }

    public static byte securityTypeMaxValue()
    {
        return (byte)126;
    }

    public static int securityTypeLength()
    {
        return 6;
    }


    public MDInstrumentDefinitionOption41Encoder securityType(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 59 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String securityTypeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putSecurityType(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 59, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder securityType(final String src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 59, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 59 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder securityType(final CharSequence src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 59, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 59 + start, (byte)0);
        }

        return this;
    }

    public static int cFICodeId()
    {
        return 461;
    }

    public static int cFICodeSinceVersion()
    {
        return 0;
    }

    public static int cFICodeEncodingOffset()
    {
        return 65;
    }

    public static int cFICodeEncodingLength()
    {
        return 6;
    }

    public static String cFICodeMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte cFICodeNullValue()
    {
        return (byte)0;
    }

    public static byte cFICodeMinValue()
    {
        return (byte)32;
    }

    public static byte cFICodeMaxValue()
    {
        return (byte)126;
    }

    public static int cFICodeLength()
    {
        return 6;
    }


    public MDInstrumentDefinitionOption41Encoder cFICode(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 65 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String cFICodeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putCFICode(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 65, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder cFICode(final String src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 65, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 65 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder cFICode(final CharSequence src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 65, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 65 + start, (byte)0);
        }

        return this;
    }

    public static int putOrCallId()
    {
        return 201;
    }

    public static int putOrCallSinceVersion()
    {
        return 3;
    }

    public static int putOrCallEncodingOffset()
    {
        return 71;
    }

    public static int putOrCallEncodingLength()
    {
        return 1;
    }

    public static String putOrCallMetaAttribute(final MetaAttribute metaAttribute)
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

    public MDInstrumentDefinitionOption41Encoder putOrCall(final PutOrCall value)
    {
        buffer.putByte(offset + 71, (byte)value.value());
        return this;
    }

    public static int maturityMonthYearId()
    {
        return 200;
    }

    public static int maturityMonthYearSinceVersion()
    {
        return 0;
    }

    public static int maturityMonthYearEncodingOffset()
    {
        return 72;
    }

    public static int maturityMonthYearEncodingLength()
    {
        return 5;
    }

    public static String maturityMonthYearMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "MonthYear";
        }

        return "";
    }

    private final MaturityMonthYearEncoder maturityMonthYear = new MaturityMonthYearEncoder();

    /**
     * This field provides the actual calendar date for contract maturity
     *
     * @return MaturityMonthYearEncoder : This field provides the actual calendar date for contract maturity
     */
    public MaturityMonthYearEncoder maturityMonthYear()
    {
        maturityMonthYear.wrap(buffer, offset + 72);
        return maturityMonthYear;
    }

    public static int currencyId()
    {
        return 15;
    }

    public static int currencySinceVersion()
    {
        return 0;
    }

    public static int currencyEncodingOffset()
    {
        return 77;
    }

    public static int currencyEncodingLength()
    {
        return 3;
    }

    public static String currencyMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "Currency";
        }

        return "";
    }

    public static byte currencyNullValue()
    {
        return (byte)0;
    }

    public static byte currencyMinValue()
    {
        return (byte)32;
    }

    public static byte currencyMaxValue()
    {
        return (byte)126;
    }

    public static int currencyLength()
    {
        return 3;
    }


    public MDInstrumentDefinitionOption41Encoder currency(final int index, final byte value)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 77 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }
    public MDInstrumentDefinitionOption41Encoder putCurrency(final byte value0, final byte value1, final byte value2)
    {
        buffer.putByte(offset + 77, value0);
        buffer.putByte(offset + 78, value1);
        buffer.putByte(offset + 79, value2);

        return this;
    }

    public static String currencyCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putCurrency(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 77, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder currency(final String src)
    {
        final int length = 3;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 77, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 77 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder currency(final CharSequence src)
    {
        final int length = 3;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 77, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 77 + start, (byte)0);
        }

        return this;
    }

    public static int strikePriceId()
    {
        return 202;
    }

    public static int strikePriceSinceVersion()
    {
        return 0;
    }

    public static int strikePriceEncodingOffset()
    {
        return 80;
    }

    public static int strikePriceEncodingLength()
    {
        return 8;
    }

    public static String strikePriceMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLEncoder strikePrice = new PRICENULLEncoder();

    /**
     * Strike Price for an option instrument
     *
     * @return PRICENULLEncoder : Strike Price for an option instrument
     */
    public PRICENULLEncoder strikePrice()
    {
        strikePrice.wrap(buffer, offset + 80);
        return strikePrice;
    }

    public static int strikeCurrencyId()
    {
        return 947;
    }

    public static int strikeCurrencySinceVersion()
    {
        return 0;
    }

    public static int strikeCurrencyEncodingOffset()
    {
        return 88;
    }

    public static int strikeCurrencyEncodingLength()
    {
        return 3;
    }

    public static String strikeCurrencyMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "Currency";
        }

        return "";
    }

    public static byte strikeCurrencyNullValue()
    {
        return (byte)0;
    }

    public static byte strikeCurrencyMinValue()
    {
        return (byte)32;
    }

    public static byte strikeCurrencyMaxValue()
    {
        return (byte)126;
    }

    public static int strikeCurrencyLength()
    {
        return 3;
    }


    public MDInstrumentDefinitionOption41Encoder strikeCurrency(final int index, final byte value)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 88 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }
    public MDInstrumentDefinitionOption41Encoder putStrikeCurrency(final byte value0, final byte value1, final byte value2)
    {
        buffer.putByte(offset + 88, value0);
        buffer.putByte(offset + 89, value1);
        buffer.putByte(offset + 90, value2);

        return this;
    }

    public static String strikeCurrencyCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putStrikeCurrency(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 88, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder strikeCurrency(final String src)
    {
        final int length = 3;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 88, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 88 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder strikeCurrency(final CharSequence src)
    {
        final int length = 3;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 88, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 88 + start, (byte)0);
        }

        return this;
    }

    public static int settlCurrencyId()
    {
        return 120;
    }

    public static int settlCurrencySinceVersion()
    {
        return 0;
    }

    public static int settlCurrencyEncodingOffset()
    {
        return 91;
    }

    public static int settlCurrencyEncodingLength()
    {
        return 3;
    }

    public static String settlCurrencyMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "Currency";
        }

        return "";
    }

    public static byte settlCurrencyNullValue()
    {
        return (byte)0;
    }

    public static byte settlCurrencyMinValue()
    {
        return (byte)32;
    }

    public static byte settlCurrencyMaxValue()
    {
        return (byte)126;
    }

    public static int settlCurrencyLength()
    {
        return 3;
    }


    public MDInstrumentDefinitionOption41Encoder settlCurrency(final int index, final byte value)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 91 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }
    public MDInstrumentDefinitionOption41Encoder putSettlCurrency(final byte value0, final byte value1, final byte value2)
    {
        buffer.putByte(offset + 91, value0);
        buffer.putByte(offset + 92, value1);
        buffer.putByte(offset + 93, value2);

        return this;
    }

    public static String settlCurrencyCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putSettlCurrency(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 91, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder settlCurrency(final String src)
    {
        final int length = 3;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 91, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 91 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder settlCurrency(final CharSequence src)
    {
        final int length = 3;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 91, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 91 + start, (byte)0);
        }

        return this;
    }

    public static int minCabPriceId()
    {
        return 9850;
    }

    public static int minCabPriceSinceVersion()
    {
        return 0;
    }

    public static int minCabPriceEncodingOffset()
    {
        return 94;
    }

    public static int minCabPriceEncodingLength()
    {
        return 8;
    }

    public static String minCabPriceMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLEncoder minCabPrice = new PRICENULLEncoder();

    /**
     * Defines cabinet price for outright options products
     *
     * @return PRICENULLEncoder : Defines cabinet price for outright options products
     */
    public PRICENULLEncoder minCabPrice()
    {
        minCabPrice.wrap(buffer, offset + 94);
        return minCabPrice;
    }

    public static int matchAlgorithmId()
    {
        return 1142;
    }

    public static int matchAlgorithmSinceVersion()
    {
        return 0;
    }

    public static int matchAlgorithmEncodingOffset()
    {
        return 102;
    }

    public static int matchAlgorithmEncodingLength()
    {
        return 1;
    }

    public static String matchAlgorithmMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte matchAlgorithmNullValue()
    {
        return (byte)0;
    }

    public static byte matchAlgorithmMinValue()
    {
        return (byte)32;
    }

    public static byte matchAlgorithmMaxValue()
    {
        return (byte)126;
    }

    public MDInstrumentDefinitionOption41Encoder matchAlgorithm(final byte value)
    {
        buffer.putByte(offset + 102, value);
        return this;
    }


    public static int minTradeVolId()
    {
        return 562;
    }

    public static int minTradeVolSinceVersion()
    {
        return 0;
    }

    public static int minTradeVolEncodingOffset()
    {
        return 103;
    }

    public static int minTradeVolEncodingLength()
    {
        return 4;
    }

    public static String minTradeVolMetaAttribute(final MetaAttribute metaAttribute)
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

    public static long minTradeVolNullValue()
    {
        return 4294967295L;
    }

    public static long minTradeVolMinValue()
    {
        return 0L;
    }

    public static long minTradeVolMaxValue()
    {
        return 4294967294L;
    }

    public MDInstrumentDefinitionOption41Encoder minTradeVol(final long value)
    {
        buffer.putInt(offset + 103, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int maxTradeVolId()
    {
        return 1140;
    }

    public static int maxTradeVolSinceVersion()
    {
        return 0;
    }

    public static int maxTradeVolEncodingOffset()
    {
        return 107;
    }

    public static int maxTradeVolEncodingLength()
    {
        return 4;
    }

    public static String maxTradeVolMetaAttribute(final MetaAttribute metaAttribute)
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

    public static long maxTradeVolNullValue()
    {
        return 4294967295L;
    }

    public static long maxTradeVolMinValue()
    {
        return 0L;
    }

    public static long maxTradeVolMaxValue()
    {
        return 4294967294L;
    }

    public MDInstrumentDefinitionOption41Encoder maxTradeVol(final long value)
    {
        buffer.putInt(offset + 107, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int minPriceIncrementId()
    {
        return 969;
    }

    public static int minPriceIncrementSinceVersion()
    {
        return 0;
    }

    public static int minPriceIncrementEncodingOffset()
    {
        return 111;
    }

    public static int minPriceIncrementEncodingLength()
    {
        return 8;
    }

    public static String minPriceIncrementMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLEncoder minPriceIncrement = new PRICENULLEncoder();

    /**
     * Minimum constant tick for the instrument
     *
     * @return PRICENULLEncoder : Minimum constant tick for the instrument
     */
    public PRICENULLEncoder minPriceIncrement()
    {
        minPriceIncrement.wrap(buffer, offset + 111);
        return minPriceIncrement;
    }

    public static int minPriceIncrementAmountId()
    {
        return 1146;
    }

    public static int minPriceIncrementAmountSinceVersion()
    {
        return 0;
    }

    public static int minPriceIncrementAmountEncodingOffset()
    {
        return 119;
    }

    public static int minPriceIncrementAmountEncodingLength()
    {
        return 8;
    }

    public static String minPriceIncrementAmountMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLEncoder minPriceIncrementAmount = new PRICENULLEncoder();

    /**
     * Monetary value equivalent to the minimum price fluctuation
     *
     * @return PRICENULLEncoder : Monetary value equivalent to the minimum price fluctuation
     */
    public PRICENULLEncoder minPriceIncrementAmount()
    {
        minPriceIncrementAmount.wrap(buffer, offset + 119);
        return minPriceIncrementAmount;
    }

    public static int displayFactorId()
    {
        return 9787;
    }

    public static int displayFactorSinceVersion()
    {
        return 0;
    }

    public static int displayFactorEncodingOffset()
    {
        return 127;
    }

    public static int displayFactorEncodingLength()
    {
        return 8;
    }

    public static String displayFactorMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "float";
        }

        return "";
    }

    private final FLOATEncoder displayFactor = new FLOATEncoder();

    /**
     * Contains the multiplier to convert the CME Globex display price to the conventional price
     *
     * @return FLOATEncoder : Contains the multiplier to convert the CME Globex display price to the conventional price
     */
    public FLOATEncoder displayFactor()
    {
        displayFactor.wrap(buffer, offset + 127);
        return displayFactor;
    }

    public static int tickRuleId()
    {
        return 6350;
    }

    public static int tickRuleSinceVersion()
    {
        return 0;
    }

    public static int tickRuleEncodingOffset()
    {
        return 135;
    }

    public static int tickRuleEncodingLength()
    {
        return 1;
    }

    public static String tickRuleMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte tickRuleNullValue()
    {
        return (byte)127;
    }

    public static byte tickRuleMinValue()
    {
        return (byte)-127;
    }

    public static byte tickRuleMaxValue()
    {
        return (byte)127;
    }

    public MDInstrumentDefinitionOption41Encoder tickRule(final byte value)
    {
        buffer.putByte(offset + 135, value);
        return this;
    }


    public static int mainFractionId()
    {
        return 37702;
    }

    public static int mainFractionSinceVersion()
    {
        return 0;
    }

    public static int mainFractionEncodingOffset()
    {
        return 136;
    }

    public static int mainFractionEncodingLength()
    {
        return 1;
    }

    public static String mainFractionMetaAttribute(final MetaAttribute metaAttribute)
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

    public static short mainFractionNullValue()
    {
        return (short)255;
    }

    public static short mainFractionMinValue()
    {
        return (short)0;
    }

    public static short mainFractionMaxValue()
    {
        return (short)254;
    }

    public MDInstrumentDefinitionOption41Encoder mainFraction(final short value)
    {
        buffer.putByte(offset + 136, (byte)value);
        return this;
    }


    public static int subFractionId()
    {
        return 37703;
    }

    public static int subFractionSinceVersion()
    {
        return 0;
    }

    public static int subFractionEncodingOffset()
    {
        return 137;
    }

    public static int subFractionEncodingLength()
    {
        return 1;
    }

    public static String subFractionMetaAttribute(final MetaAttribute metaAttribute)
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

    public static short subFractionNullValue()
    {
        return (short)255;
    }

    public static short subFractionMinValue()
    {
        return (short)0;
    }

    public static short subFractionMaxValue()
    {
        return (short)254;
    }

    public MDInstrumentDefinitionOption41Encoder subFraction(final short value)
    {
        buffer.putByte(offset + 137, (byte)value);
        return this;
    }


    public static int priceDisplayFormatId()
    {
        return 9800;
    }

    public static int priceDisplayFormatSinceVersion()
    {
        return 0;
    }

    public static int priceDisplayFormatEncodingOffset()
    {
        return 138;
    }

    public static int priceDisplayFormatEncodingLength()
    {
        return 1;
    }

    public static String priceDisplayFormatMetaAttribute(final MetaAttribute metaAttribute)
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

    public static short priceDisplayFormatNullValue()
    {
        return (short)255;
    }

    public static short priceDisplayFormatMinValue()
    {
        return (short)0;
    }

    public static short priceDisplayFormatMaxValue()
    {
        return (short)254;
    }

    public MDInstrumentDefinitionOption41Encoder priceDisplayFormat(final short value)
    {
        buffer.putByte(offset + 138, (byte)value);
        return this;
    }


    public static int unitOfMeasureId()
    {
        return 996;
    }

    public static int unitOfMeasureSinceVersion()
    {
        return 0;
    }

    public static int unitOfMeasureEncodingOffset()
    {
        return 139;
    }

    public static int unitOfMeasureEncodingLength()
    {
        return 30;
    }

    public static String unitOfMeasureMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte unitOfMeasureNullValue()
    {
        return (byte)0;
    }

    public static byte unitOfMeasureMinValue()
    {
        return (byte)32;
    }

    public static byte unitOfMeasureMaxValue()
    {
        return (byte)126;
    }

    public static int unitOfMeasureLength()
    {
        return 30;
    }


    public MDInstrumentDefinitionOption41Encoder unitOfMeasure(final int index, final byte value)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 139 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String unitOfMeasureCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public MDInstrumentDefinitionOption41Encoder putUnitOfMeasure(final byte[] src, final int srcOffset)
    {
        final int length = 30;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 139, src, srcOffset, length);

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder unitOfMeasure(final String src)
    {
        final int length = 30;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 139, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 139 + start, (byte)0);
        }

        return this;
    }

    public MDInstrumentDefinitionOption41Encoder unitOfMeasure(final CharSequence src)
    {
        final int length = 30;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 139, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 139 + start, (byte)0);
        }

        return this;
    }

    public static int unitOfMeasureQtyId()
    {
        return 1147;
    }

    public static int unitOfMeasureQtySinceVersion()
    {
        return 0;
    }

    public static int unitOfMeasureQtyEncodingOffset()
    {
        return 169;
    }

    public static int unitOfMeasureQtyEncodingLength()
    {
        return 8;
    }

    public static String unitOfMeasureQtyMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLEncoder unitOfMeasureQty = new PRICENULLEncoder();

    /**
     * This field contains the contract size for each instrument. Used in combination with tag 996-UnitofMeasure
     *
     * @return PRICENULLEncoder : This field contains the contract size for each instrument. Used in combination with tag 996-UnitofMeasure
     */
    public PRICENULLEncoder unitOfMeasureQty()
    {
        unitOfMeasureQty.wrap(buffer, offset + 169);
        return unitOfMeasureQty;
    }

    public static int tradingReferencePriceId()
    {
        return 1150;
    }

    public static int tradingReferencePriceSinceVersion()
    {
        return 0;
    }

    public static int tradingReferencePriceEncodingOffset()
    {
        return 177;
    }

    public static int tradingReferencePriceEncodingLength()
    {
        return 8;
    }

    public static String tradingReferencePriceMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLEncoder tradingReferencePrice = new PRICENULLEncoder();

    /**
     * Reference price - the most recently available Settlement whether it be Theoretical, Preliminary or a Final Settle of the session
     *
     * @return PRICENULLEncoder : Reference price - the most recently available Settlement whether it be Theoretical, Preliminary or a Final Settle of the session
     */
    public PRICENULLEncoder tradingReferencePrice()
    {
        tradingReferencePrice.wrap(buffer, offset + 177);
        return tradingReferencePrice;
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
        return 185;
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
        settlPriceType.wrap(buffer, offset + 185);
        return settlPriceType;
    }

    public static int clearedVolumeId()
    {
        return 5791;
    }

    public static int clearedVolumeSinceVersion()
    {
        return 0;
    }

    public static int clearedVolumeEncodingOffset()
    {
        return 186;
    }

    public static int clearedVolumeEncodingLength()
    {
        return 4;
    }

    public static String clearedVolumeMetaAttribute(final MetaAttribute metaAttribute)
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

    public static int clearedVolumeNullValue()
    {
        return 2147483647;
    }

    public static int clearedVolumeMinValue()
    {
        return -2147483647;
    }

    public static int clearedVolumeMaxValue()
    {
        return 2147483647;
    }

    public MDInstrumentDefinitionOption41Encoder clearedVolume(final int value)
    {
        buffer.putInt(offset + 186, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int openInterestQtyId()
    {
        return 5792;
    }

    public static int openInterestQtySinceVersion()
    {
        return 0;
    }

    public static int openInterestQtyEncodingOffset()
    {
        return 190;
    }

    public static int openInterestQtyEncodingLength()
    {
        return 4;
    }

    public static String openInterestQtyMetaAttribute(final MetaAttribute metaAttribute)
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

    public static int openInterestQtyNullValue()
    {
        return 2147483647;
    }

    public static int openInterestQtyMinValue()
    {
        return -2147483647;
    }

    public static int openInterestQtyMaxValue()
    {
        return 2147483647;
    }

    public MDInstrumentDefinitionOption41Encoder openInterestQty(final int value)
    {
        buffer.putInt(offset + 190, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
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
        return 194;
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

    private final PRICENULLEncoder lowLimitPrice = new PRICENULLEncoder();

    /**
     * Allowable low limit price for the trading day 
     *
     * @return PRICENULLEncoder : Allowable low limit price for the trading day 
     */
    public PRICENULLEncoder lowLimitPrice()
    {
        lowLimitPrice.wrap(buffer, offset + 194);
        return lowLimitPrice;
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
        return 202;
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

    private final PRICENULLEncoder highLimitPrice = new PRICENULLEncoder();

    /**
     * Allowable high limit price for the trading day
     *
     * @return PRICENULLEncoder : Allowable high limit price for the trading day
     */
    public PRICENULLEncoder highLimitPrice()
    {
        highLimitPrice.wrap(buffer, offset + 202);
        return highLimitPrice;
    }

    public static int userDefinedInstrumentId()
    {
        return 9779;
    }

    public static int userDefinedInstrumentSinceVersion()
    {
        return 0;
    }

    public static int userDefinedInstrumentEncodingOffset()
    {
        return 210;
    }

    public static int userDefinedInstrumentEncodingLength()
    {
        return 1;
    }

    public static String userDefinedInstrumentMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte userDefinedInstrumentNullValue()
    {
        return (byte)0;
    }

    public static byte userDefinedInstrumentMinValue()
    {
        return (byte)32;
    }

    public static byte userDefinedInstrumentMaxValue()
    {
        return (byte)126;
    }

    public MDInstrumentDefinitionOption41Encoder userDefinedInstrument(final byte value)
    {
        buffer.putByte(offset + 210, value);
        return this;
    }


    public static int tradingReferenceDateId()
    {
        return 5796;
    }

    public static int tradingReferenceDateSinceVersion()
    {
        return 6;
    }

    public static int tradingReferenceDateEncodingOffset()
    {
        return 211;
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

    public MDInstrumentDefinitionOption41Encoder tradingReferenceDate(final int value)
    {
        buffer.putShort(offset + 211, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    private final NoEventsEncoder noEvents = new NoEventsEncoder(this);

    public static long noEventsId()
    {
        return 864;
    }

    /**
     * Number of EventType entries
     *
     * @param count of times the group will be encoded.
     * @return NoEventsEncoder : encoder for the group.
     */
    public NoEventsEncoder noEventsCount(final int count)
    {
        noEvents.wrap(buffer, count);
        return noEvents;
    }

    /**
     * Number of EventType entries
     */

    public static final class NoEventsEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoEventsEncoder(final MDInstrumentDefinitionOption41Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)9, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoEventsEncoder next()
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
            return 9;
        }

        public static int eventTypeId()
        {
            return 865;
        }

        public static int eventTypeSinceVersion()
        {
            return 0;
        }

        public static int eventTypeEncodingOffset()
        {
            return 0;
        }

        public static int eventTypeEncodingLength()
        {
            return 1;
        }

        public static String eventTypeMetaAttribute(final MetaAttribute metaAttribute)
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

        public NoEventsEncoder eventType(final EventType value)
        {
            buffer.putByte(offset + 0, (byte)value.value());
            return this;
        }

        public static int eventTimeId()
        {
            return 1145;
        }

        public static int eventTimeSinceVersion()
        {
            return 0;
        }

        public static int eventTimeEncodingOffset()
        {
            return 1;
        }

        public static int eventTimeEncodingLength()
        {
            return 8;
        }

        public static String eventTimeMetaAttribute(final MetaAttribute metaAttribute)
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

        public static long eventTimeNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long eventTimeMinValue()
        {
            return 0x0L;
        }

        public static long eventTimeMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public NoEventsEncoder eventTime(final long value)
        {
            buffer.putLong(offset + 1, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }

    }

    private final NoMDFeedTypesEncoder noMDFeedTypes = new NoMDFeedTypesEncoder(this);

    public static long noMDFeedTypesId()
    {
        return 1141;
    }

    /**
     * Number of FeedType entries
     *
     * @param count of times the group will be encoded.
     * @return NoMDFeedTypesEncoder : encoder for the group.
     */
    public NoMDFeedTypesEncoder noMDFeedTypesCount(final int count)
    {
        noMDFeedTypes.wrap(buffer, count);
        return noMDFeedTypes;
    }

    /**
     * Number of FeedType entries
     */

    public static final class NoMDFeedTypesEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoMDFeedTypesEncoder(final MDInstrumentDefinitionOption41Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)4, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoMDFeedTypesEncoder next()
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
            return 4;
        }

        public static int mDFeedTypeId()
        {
            return 1022;
        }

        public static int mDFeedTypeSinceVersion()
        {
            return 0;
        }

        public static int mDFeedTypeEncodingOffset()
        {
            return 0;
        }

        public static int mDFeedTypeEncodingLength()
        {
            return 3;
        }

        public static String mDFeedTypeMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte mDFeedTypeNullValue()
        {
            return (byte)0;
        }

        public static byte mDFeedTypeMinValue()
        {
            return (byte)32;
        }

        public static byte mDFeedTypeMaxValue()
        {
            return (byte)126;
        }

        public static int mDFeedTypeLength()
        {
            return 3;
        }


        public NoMDFeedTypesEncoder mDFeedType(final int index, final byte value)
        {
            if (index < 0 || index >= 3)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 0 + (index * 1);
            buffer.putByte(pos, value);

            return this;
        }
        public NoMDFeedTypesEncoder putMDFeedType(final byte value0, final byte value1, final byte value2)
        {
            buffer.putByte(offset + 0, value0);
            buffer.putByte(offset + 1, value1);
            buffer.putByte(offset + 2, value2);

            return this;
        }

        public static String mDFeedTypeCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public NoMDFeedTypesEncoder putMDFeedType(final byte[] src, final int srcOffset)
        {
            final int length = 3;
            if (srcOffset < 0 || srcOffset > (src.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
            }

            buffer.putBytes(offset + 0, src, srcOffset, length);

            return this;
        }

        public NoMDFeedTypesEncoder mDFeedType(final String src)
        {
            final int length = 3;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(offset + 0, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(offset + 0 + start, (byte)0);
            }

            return this;
        }

        public NoMDFeedTypesEncoder mDFeedType(final CharSequence src)
        {
            final int length = 3;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(offset + 0, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(offset + 0 + start, (byte)0);
            }

            return this;
        }

        public static int marketDepthId()
        {
            return 264;
        }

        public static int marketDepthSinceVersion()
        {
            return 0;
        }

        public static int marketDepthEncodingOffset()
        {
            return 3;
        }

        public static int marketDepthEncodingLength()
        {
            return 1;
        }

        public static String marketDepthMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte marketDepthNullValue()
        {
            return (byte)-128;
        }

        public static byte marketDepthMinValue()
        {
            return (byte)-127;
        }

        public static byte marketDepthMaxValue()
        {
            return (byte)127;
        }

        public NoMDFeedTypesEncoder marketDepth(final byte value)
        {
            buffer.putByte(offset + 3, value);
            return this;
        }

    }

    private final NoInstAttribEncoder noInstAttrib = new NoInstAttribEncoder(this);

    public static long noInstAttribId()
    {
        return 870;
    }

    /**
     * Number of InstrAttribType entries
     *
     * @param count of times the group will be encoded.
     * @return NoInstAttribEncoder : encoder for the group.
     */
    public NoInstAttribEncoder noInstAttribCount(final int count)
    {
        noInstAttrib.wrap(buffer, count);
        return noInstAttrib;
    }

    /**
     * Number of InstrAttribType entries
     */

    public static final class NoInstAttribEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoInstAttribEncoder(final MDInstrumentDefinitionOption41Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)4, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoInstAttribEncoder next()
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
            return 4;
        }

        public static int instAttribTypeId()
        {
            return 871;
        }

        public static int instAttribTypeSinceVersion()
        {
            return 0;
        }

        public static int instAttribTypeEncodingOffset()
        {
            return 0;
        }

        public static int instAttribTypeEncodingLength()
        {
            return 0;
        }

        public static String instAttribTypeMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte instAttribTypeNullValue()
        {
            return (byte)-128;
        }

        public static byte instAttribTypeMinValue()
        {
            return (byte)-127;
        }

        public static byte instAttribTypeMaxValue()
        {
            return (byte)127;
        }

        public byte instAttribType()
        {
            return (byte)24;
        }

        public static int instAttribValueId()
        {
            return 872;
        }

        public static int instAttribValueSinceVersion()
        {
            return 0;
        }

        public static int instAttribValueEncodingOffset()
        {
            return 0;
        }

        public static int instAttribValueEncodingLength()
        {
            return 4;
        }

        public static String instAttribValueMetaAttribute(final MetaAttribute metaAttribute)
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

        private final InstAttribValueEncoder instAttribValue = new InstAttribValueEncoder();

        /**
         * Bitmap field of 32 Boolean type Instrument eligibility flags
         *
         * @return InstAttribValueEncoder : Bitmap field of 32 Boolean type Instrument eligibility flags
         */
        public InstAttribValueEncoder instAttribValue()
        {
            instAttribValue.wrap(buffer, offset + 0);
            return instAttribValue;
        }
    }

    private final NoLotTypeRulesEncoder noLotTypeRules = new NoLotTypeRulesEncoder(this);

    public static long noLotTypeRulesId()
    {
        return 1234;
    }

    /**
     * Number of entries
     *
     * @param count of times the group will be encoded.
     * @return NoLotTypeRulesEncoder : encoder for the group.
     */
    public NoLotTypeRulesEncoder noLotTypeRulesCount(final int count)
    {
        noLotTypeRules.wrap(buffer, count);
        return noLotTypeRules;
    }

    /**
     * Number of entries
     */

    public static final class NoLotTypeRulesEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoLotTypeRulesEncoder(final MDInstrumentDefinitionOption41Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)5, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoLotTypeRulesEncoder next()
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
            return 5;
        }

        public static int lotTypeId()
        {
            return 1093;
        }

        public static int lotTypeSinceVersion()
        {
            return 0;
        }

        public static int lotTypeEncodingOffset()
        {
            return 0;
        }

        public static int lotTypeEncodingLength()
        {
            return 1;
        }

        public static String lotTypeMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte lotTypeNullValue()
        {
            return (byte)-128;
        }

        public static byte lotTypeMinValue()
        {
            return (byte)-127;
        }

        public static byte lotTypeMaxValue()
        {
            return (byte)127;
        }

        public NoLotTypeRulesEncoder lotType(final byte value)
        {
            buffer.putByte(offset + 0, value);
            return this;
        }


        public static int minLotSizeId()
        {
            return 1231;
        }

        public static int minLotSizeSinceVersion()
        {
            return 0;
        }

        public static int minLotSizeEncodingOffset()
        {
            return 1;
        }

        public static int minLotSizeEncodingLength()
        {
            return 4;
        }

        public static String minLotSizeMetaAttribute(final MetaAttribute metaAttribute)
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

        private final DecimalQtyEncoder minLotSize = new DecimalQtyEncoder();

        /**
         * Minimum quantity accepted for order entry. If tag 1093-LotType=4, this value is the minimum quantity for order entry expressed in the applicable units, specified in tag 996-UnitOfMeasure, e.g. megawatts
         *
         * @return DecimalQtyEncoder : Minimum quantity accepted for order entry. If tag 1093-LotType=4, this value is the minimum quantity for order entry expressed in the applicable units, specified in tag 996-UnitOfMeasure, e.g. megawatts
         */
        public DecimalQtyEncoder minLotSize()
        {
            minLotSize.wrap(buffer, offset + 1);
            return minLotSize;
        }
    }

    private final NoUnderlyingsEncoder noUnderlyings = new NoUnderlyingsEncoder(this);

    public static long noUnderlyingsId()
    {
        return 711;
    }

    /**
     * Number of underlying instruments
     *
     * @param count of times the group will be encoded.
     * @return NoUnderlyingsEncoder : encoder for the group.
     */
    public NoUnderlyingsEncoder noUnderlyingsCount(final int count)
    {
        noUnderlyings.wrap(buffer, count);
        return noUnderlyings;
    }

    /**
     * Number of underlying instruments
     */

    public static final class NoUnderlyingsEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoUnderlyingsEncoder(final MDInstrumentDefinitionOption41Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)24, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoUnderlyingsEncoder next()
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
            return 24;
        }

        public static int underlyingSecurityIDId()
        {
            return 309;
        }

        public static int underlyingSecurityIDSinceVersion()
        {
            return 0;
        }

        public static int underlyingSecurityIDEncodingOffset()
        {
            return 0;
        }

        public static int underlyingSecurityIDEncodingLength()
        {
            return 4;
        }

        public static String underlyingSecurityIDMetaAttribute(final MetaAttribute metaAttribute)
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

        public static int underlyingSecurityIDNullValue()
        {
            return -2147483648;
        }

        public static int underlyingSecurityIDMinValue()
        {
            return -2147483647;
        }

        public static int underlyingSecurityIDMaxValue()
        {
            return 2147483647;
        }

        public NoUnderlyingsEncoder underlyingSecurityID(final int value)
        {
            buffer.putInt(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int underlyingSecurityIDSourceId()
        {
            return 305;
        }

        public static int underlyingSecurityIDSourceSinceVersion()
        {
            return 0;
        }

        public static int underlyingSecurityIDSourceEncodingOffset()
        {
            return 4;
        }

        public static int underlyingSecurityIDSourceEncodingLength()
        {
            return 0;
        }

        public static String underlyingSecurityIDSourceMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte underlyingSecurityIDSourceNullValue()
        {
            return (byte)0;
        }

        public static byte underlyingSecurityIDSourceMinValue()
        {
            return (byte)32;
        }

        public static byte underlyingSecurityIDSourceMaxValue()
        {
            return (byte)126;
        }


        private static final byte[] UNDERLYINGSECURITYIDSOURCE_VALUE = { 56 };

        public static int underlyingSecurityIDSourceLength()
        {
            return 1;
        }


        public byte underlyingSecurityIDSource(final int index)
        {
            return UNDERLYINGSECURITYIDSOURCE_VALUE[index];
        }

        public int getUnderlyingSecurityIDSource(final byte[] dst, final int offset, final int length)
        {
            final int bytesCopied = Math.min(length, 1);
            System.arraycopy(UNDERLYINGSECURITYIDSOURCE_VALUE, 0, dst, offset, bytesCopied);

            return bytesCopied;
        }

        public byte underlyingSecurityIDSource()
        {
            return (byte)56;
        }


        public static int underlyingSymbolId()
        {
            return 311;
        }

        public static int underlyingSymbolSinceVersion()
        {
            return 0;
        }

        public static int underlyingSymbolEncodingOffset()
        {
            return 4;
        }

        public static int underlyingSymbolEncodingLength()
        {
            return 20;
        }

        public static String underlyingSymbolMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte underlyingSymbolNullValue()
        {
            return (byte)0;
        }

        public static byte underlyingSymbolMinValue()
        {
            return (byte)32;
        }

        public static byte underlyingSymbolMaxValue()
        {
            return (byte)126;
        }

        public static int underlyingSymbolLength()
        {
            return 20;
        }


        public NoUnderlyingsEncoder underlyingSymbol(final int index, final byte value)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 4 + (index * 1);
            buffer.putByte(pos, value);

            return this;
        }

        public static String underlyingSymbolCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public NoUnderlyingsEncoder putUnderlyingSymbol(final byte[] src, final int srcOffset)
        {
            final int length = 20;
            if (srcOffset < 0 || srcOffset > (src.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
            }

            buffer.putBytes(offset + 4, src, srcOffset, length);

            return this;
        }

        public NoUnderlyingsEncoder underlyingSymbol(final String src)
        {
            final int length = 20;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(offset + 4, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(offset + 4 + start, (byte)0);
            }

            return this;
        }

        public NoUnderlyingsEncoder underlyingSymbol(final CharSequence src)
        {
            final int length = 20;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(offset + 4, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(offset + 4 + start, (byte)0);
            }

            return this;
        }
    }

    private final NoRelatedInstrumentsEncoder noRelatedInstruments = new NoRelatedInstrumentsEncoder(this);

    public static long noRelatedInstrumentsId()
    {
        return 1647;
    }

    /**
     * Number of related instruments group
     *
     * @param count of times the group will be encoded.
     * @return NoRelatedInstrumentsEncoder : encoder for the group.
     */
    public NoRelatedInstrumentsEncoder noRelatedInstrumentsCount(final int count)
    {
        noRelatedInstruments.wrap(buffer, count);
        return noRelatedInstruments;
    }

    /**
     * Number of related instruments group
     */

    public static final class NoRelatedInstrumentsEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Encoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;

        NoRelatedInstrumentsEncoder(final MDInstrumentDefinitionOption41Encoder parentMessage)
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
            buffer.putShort(limit + 0, (short)24, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public NoRelatedInstrumentsEncoder next()
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
            return 24;
        }

        public static int relatedSecurityIDId()
        {
            return 1650;
        }

        public static int relatedSecurityIDSinceVersion()
        {
            return 0;
        }

        public static int relatedSecurityIDEncodingOffset()
        {
            return 0;
        }

        public static int relatedSecurityIDEncodingLength()
        {
            return 4;
        }

        public static String relatedSecurityIDMetaAttribute(final MetaAttribute metaAttribute)
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

        public static int relatedSecurityIDNullValue()
        {
            return -2147483648;
        }

        public static int relatedSecurityIDMinValue()
        {
            return -2147483647;
        }

        public static int relatedSecurityIDMaxValue()
        {
            return 2147483647;
        }

        public NoRelatedInstrumentsEncoder relatedSecurityID(final int value)
        {
            buffer.putInt(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int relatedSecurityIDSourceId()
        {
            return 1651;
        }

        public static int relatedSecurityIDSourceSinceVersion()
        {
            return 0;
        }

        public static int relatedSecurityIDSourceEncodingOffset()
        {
            return 4;
        }

        public static int relatedSecurityIDSourceEncodingLength()
        {
            return 0;
        }

        public static String relatedSecurityIDSourceMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte relatedSecurityIDSourceNullValue()
        {
            return (byte)0;
        }

        public static byte relatedSecurityIDSourceMinValue()
        {
            return (byte)32;
        }

        public static byte relatedSecurityIDSourceMaxValue()
        {
            return (byte)126;
        }


        private static final byte[] RELATEDSECURITYIDSOURCE_VALUE = { 56 };

        public static int relatedSecurityIDSourceLength()
        {
            return 1;
        }


        public byte relatedSecurityIDSource(final int index)
        {
            return RELATEDSECURITYIDSOURCE_VALUE[index];
        }

        public int getRelatedSecurityIDSource(final byte[] dst, final int offset, final int length)
        {
            final int bytesCopied = Math.min(length, 1);
            System.arraycopy(RELATEDSECURITYIDSOURCE_VALUE, 0, dst, offset, bytesCopied);

            return bytesCopied;
        }

        public byte relatedSecurityIDSource()
        {
            return (byte)56;
        }


        public static int relatedSymbolId()
        {
            return 1649;
        }

        public static int relatedSymbolSinceVersion()
        {
            return 0;
        }

        public static int relatedSymbolEncodingOffset()
        {
            return 4;
        }

        public static int relatedSymbolEncodingLength()
        {
            return 20;
        }

        public static String relatedSymbolMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte relatedSymbolNullValue()
        {
            return (byte)0;
        }

        public static byte relatedSymbolMinValue()
        {
            return (byte)32;
        }

        public static byte relatedSymbolMaxValue()
        {
            return (byte)126;
        }

        public static int relatedSymbolLength()
        {
            return 20;
        }


        public NoRelatedInstrumentsEncoder relatedSymbol(final int index, final byte value)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 4 + (index * 1);
            buffer.putByte(pos, value);

            return this;
        }

        public static String relatedSymbolCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public NoRelatedInstrumentsEncoder putRelatedSymbol(final byte[] src, final int srcOffset)
        {
            final int length = 20;
            if (srcOffset < 0 || srcOffset > (src.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
            }

            buffer.putBytes(offset + 4, src, srcOffset, length);

            return this;
        }

        public NoRelatedInstrumentsEncoder relatedSymbol(final String src)
        {
            final int length = 20;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(offset + 4, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(offset + 4 + start, (byte)0);
            }

            return this;
        }

        public NoRelatedInstrumentsEncoder relatedSymbol(final CharSequence src)
        {
            final int length = 20;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(offset + 4, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(offset + 4 + start, (byte)0);
            }

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

        final MDInstrumentDefinitionOption41Decoder decoder = new MDInstrumentDefinitionOption41Decoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
