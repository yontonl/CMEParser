/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.DirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    MDInstrumentDefinitionOption41Decoder.NoEventsDecoder.class,
    MDInstrumentDefinitionOption41Decoder.NoMDFeedTypesDecoder.class,
    MDInstrumentDefinitionOption41Decoder.NoInstAttribDecoder.class,
    MDInstrumentDefinitionOption41Decoder.NoLotTypeRulesDecoder.class,
    MDInstrumentDefinitionOption41Decoder.NoUnderlyingsDecoder.class,
    MDInstrumentDefinitionOption41Decoder.NoRelatedInstrumentsDecoder.class})
/**
 * MDInstrumentDefinitionOption
 */
@SuppressWarnings("all")
public final class MDInstrumentDefinitionOption41Decoder implements MessageDecoderFlyweight
{
    public static final int BLOCK_LENGTH = 213;
    public static final int TEMPLATE_ID = 41;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final MDInstrumentDefinitionOption41Decoder parentMessage = this;
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
        return "d";
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

    public MDInstrumentDefinitionOption41Decoder wrap(
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

    public MDInstrumentDefinitionOption41Decoder wrapAndApplyHeader(
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

    public MDInstrumentDefinitionOption41Decoder sbeRewind()
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

    private final MatchEventIndicatorDecoder matchEventIndicator = new MatchEventIndicatorDecoder();

    /**
     * Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     *
     * @return MatchEventIndicatorDecoder : Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     */
    public MatchEventIndicatorDecoder matchEventIndicator()
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

    public long totNumReports()
    {
        return (buffer.getInt(offset + 1, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

    public byte securityUpdateActionRaw()
    {
        return buffer.getByte(offset + 5);
    }

    public SecurityUpdateAction securityUpdateAction()
    {
        return SecurityUpdateAction.get(buffer.getByte(offset + 5));
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

    public long lastUpdateTime()
    {
        return buffer.getLong(offset + 6, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public short mDSecurityTradingStatusRaw()
    {
        return ((short)(buffer.getByte(offset + 14) & 0xFF));
    }

    public SecurityTradingStatus mDSecurityTradingStatus()
    {
        return SecurityTradingStatus.get(((short)(buffer.getByte(offset + 14) & 0xFF)));
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

    public short applID()
    {
        return buffer.getShort(offset + 15, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public short marketSegmentID()
    {
        return ((short)(buffer.getByte(offset + 17) & 0xFF));
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

    public short underlyingProduct()
    {
        return ((short)(buffer.getByte(offset + 18) & 0xFF));
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


    public byte securityExchange(final int index)
    {
        if (index < 0 || index >= 4)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 19 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String securityExchangeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getSecurityExchange(final byte[] dst, final int dstOffset)
    {
        final int length = 4;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 19, dst, dstOffset, length);

        return length;
    }

    public String securityExchange()
    {
        final byte[] dst = new byte[4];
        buffer.getBytes(offset + 19, dst, 0, 4);

        int end = 0;
        for (; end < 4 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSecurityExchange(final Appendable value)
    {
        for (int i = 0; i < 4; ++i)
        {
            final int c = buffer.getByte(offset + 19 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 4;
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


    public byte securityGroup(final int index)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 23 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String securityGroupCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getSecurityGroup(final byte[] dst, final int dstOffset)
    {
        final int length = 6;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 23, dst, dstOffset, length);

        return length;
    }

    public String securityGroup()
    {
        final byte[] dst = new byte[6];
        buffer.getBytes(offset + 23, dst, 0, 6);

        int end = 0;
        for (; end < 6 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSecurityGroup(final Appendable value)
    {
        for (int i = 0; i < 6; ++i)
        {
            final int c = buffer.getByte(offset + 23 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 6;
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


    public byte asset(final int index)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 29 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String assetCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getAsset(final byte[] dst, final int dstOffset)
    {
        final int length = 6;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 29, dst, dstOffset, length);

        return length;
    }

    public String asset()
    {
        final byte[] dst = new byte[6];
        buffer.getBytes(offset + 29, dst, 0, 6);

        int end = 0;
        for (; end < 6 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getAsset(final Appendable value)
    {
        for (int i = 0; i < 6; ++i)
        {
            final int c = buffer.getByte(offset + 29 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 6;
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


    public byte symbol(final int index)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 35 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String symbolCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getSymbol(final byte[] dst, final int dstOffset)
    {
        final int length = 20;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 35, dst, dstOffset, length);

        return length;
    }

    public String symbol()
    {
        final byte[] dst = new byte[20];
        buffer.getBytes(offset + 35, dst, 0, 20);

        int end = 0;
        for (; end < 20 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSymbol(final Appendable value)
    {
        for (int i = 0; i < 20; ++i)
        {
            final int c = buffer.getByte(offset + 35 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 20;
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

    public int securityID()
    {
        return buffer.getInt(offset + 55, java.nio.ByteOrder.LITTLE_ENDIAN);
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


    public byte securityType(final int index)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 59 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String securityTypeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getSecurityType(final byte[] dst, final int dstOffset)
    {
        final int length = 6;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 59, dst, dstOffset, length);

        return length;
    }

    public String securityType()
    {
        final byte[] dst = new byte[6];
        buffer.getBytes(offset + 59, dst, 0, 6);

        int end = 0;
        for (; end < 6 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSecurityType(final Appendable value)
    {
        for (int i = 0; i < 6; ++i)
        {
            final int c = buffer.getByte(offset + 59 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 6;
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


    public byte cFICode(final int index)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 65 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String cFICodeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getCFICode(final byte[] dst, final int dstOffset)
    {
        final int length = 6;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 65, dst, dstOffset, length);

        return length;
    }

    public String cFICode()
    {
        final byte[] dst = new byte[6];
        buffer.getBytes(offset + 65, dst, 0, 6);

        int end = 0;
        for (; end < 6 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getCFICode(final Appendable value)
    {
        for (int i = 0; i < 6; ++i)
        {
            final int c = buffer.getByte(offset + 65 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 6;
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

    public short putOrCallRaw()
    {
        if (parentMessage.actingVersion < 3)
        {
            return (short)255;
        }

        return ((short)(buffer.getByte(offset + 71) & 0xFF));
    }

    public PutOrCall putOrCall()
    {
        if (parentMessage.actingVersion < 3)
        {
            return PutOrCall.NULL_VAL;
        }

        return PutOrCall.get(((short)(buffer.getByte(offset + 71) & 0xFF)));
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

    private final MaturityMonthYearDecoder maturityMonthYear = new MaturityMonthYearDecoder();

    /**
     * This field provides the actual calendar date for contract maturity
     *
     * @return MaturityMonthYearDecoder : This field provides the actual calendar date for contract maturity
     */
    public MaturityMonthYearDecoder maturityMonthYear()
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


    public byte currency(final int index)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 77 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String currencyCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getCurrency(final byte[] dst, final int dstOffset)
    {
        final int length = 3;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 77, dst, dstOffset, length);

        return length;
    }

    public String currency()
    {
        final byte[] dst = new byte[3];
        buffer.getBytes(offset + 77, dst, 0, 3);

        int end = 0;
        for (; end < 3 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getCurrency(final Appendable value)
    {
        for (int i = 0; i < 3; ++i)
        {
            final int c = buffer.getByte(offset + 77 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 3;
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

    private final PRICENULLDecoder strikePrice = new PRICENULLDecoder();

    /**
     * Strike Price for an option instrument
     *
     * @return PRICENULLDecoder : Strike Price for an option instrument
     */
    public PRICENULLDecoder strikePrice()
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


    public byte strikeCurrency(final int index)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 88 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String strikeCurrencyCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getStrikeCurrency(final byte[] dst, final int dstOffset)
    {
        final int length = 3;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 88, dst, dstOffset, length);

        return length;
    }

    public String strikeCurrency()
    {
        final byte[] dst = new byte[3];
        buffer.getBytes(offset + 88, dst, 0, 3);

        int end = 0;
        for (; end < 3 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getStrikeCurrency(final Appendable value)
    {
        for (int i = 0; i < 3; ++i)
        {
            final int c = buffer.getByte(offset + 88 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 3;
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


    public byte settlCurrency(final int index)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 91 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String settlCurrencyCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getSettlCurrency(final byte[] dst, final int dstOffset)
    {
        final int length = 3;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 91, dst, dstOffset, length);

        return length;
    }

    public String settlCurrency()
    {
        final byte[] dst = new byte[3];
        buffer.getBytes(offset + 91, dst, 0, 3);

        int end = 0;
        for (; end < 3 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSettlCurrency(final Appendable value)
    {
        for (int i = 0; i < 3; ++i)
        {
            final int c = buffer.getByte(offset + 91 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 3;
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

    private final PRICENULLDecoder minCabPrice = new PRICENULLDecoder();

    /**
     * Defines cabinet price for outright options products
     *
     * @return PRICENULLDecoder : Defines cabinet price for outright options products
     */
    public PRICENULLDecoder minCabPrice()
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

    public byte matchAlgorithm()
    {
        return buffer.getByte(offset + 102);
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

    public long minTradeVol()
    {
        return (buffer.getInt(offset + 103, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

    public long maxTradeVol()
    {
        return (buffer.getInt(offset + 107, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

    private final PRICENULLDecoder minPriceIncrement = new PRICENULLDecoder();

    /**
     * Minimum constant tick for the instrument
     *
     * @return PRICENULLDecoder : Minimum constant tick for the instrument
     */
    public PRICENULLDecoder minPriceIncrement()
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

    private final PRICENULLDecoder minPriceIncrementAmount = new PRICENULLDecoder();

    /**
     * Monetary value equivalent to the minimum price fluctuation
     *
     * @return PRICENULLDecoder : Monetary value equivalent to the minimum price fluctuation
     */
    public PRICENULLDecoder minPriceIncrementAmount()
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

    private final FLOATDecoder displayFactor = new FLOATDecoder();

    /**
     * Contains the multiplier to convert the CME Globex display price to the conventional price
     *
     * @return FLOATDecoder : Contains the multiplier to convert the CME Globex display price to the conventional price
     */
    public FLOATDecoder displayFactor()
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

    public byte tickRule()
    {
        return buffer.getByte(offset + 135);
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

    public short mainFraction()
    {
        return ((short)(buffer.getByte(offset + 136) & 0xFF));
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

    public short subFraction()
    {
        return ((short)(buffer.getByte(offset + 137) & 0xFF));
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

    public short priceDisplayFormat()
    {
        return ((short)(buffer.getByte(offset + 138) & 0xFF));
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


    public byte unitOfMeasure(final int index)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 139 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String unitOfMeasureCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getUnitOfMeasure(final byte[] dst, final int dstOffset)
    {
        final int length = 30;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 139, dst, dstOffset, length);

        return length;
    }

    public String unitOfMeasure()
    {
        final byte[] dst = new byte[30];
        buffer.getBytes(offset + 139, dst, 0, 30);

        int end = 0;
        for (; end < 30 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getUnitOfMeasure(final Appendable value)
    {
        for (int i = 0; i < 30; ++i)
        {
            final int c = buffer.getByte(offset + 139 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 30;
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

    private final PRICENULLDecoder unitOfMeasureQty = new PRICENULLDecoder();

    /**
     * This field contains the contract size for each instrument. Used in combination with tag 996-UnitofMeasure
     *
     * @return PRICENULLDecoder : This field contains the contract size for each instrument. Used in combination with tag 996-UnitofMeasure
     */
    public PRICENULLDecoder unitOfMeasureQty()
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

    private final PRICENULLDecoder tradingReferencePrice = new PRICENULLDecoder();

    /**
     * Reference price - the most recently available Settlement whether it be Theoretical, Preliminary or a Final Settle of the session
     *
     * @return PRICENULLDecoder : Reference price - the most recently available Settlement whether it be Theoretical, Preliminary or a Final Settle of the session
     */
    public PRICENULLDecoder tradingReferencePrice()
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

    private final SettlPriceTypeDecoder settlPriceType = new SettlPriceTypeDecoder();

    /**
     * Bitmap field of eight Boolean type indicators representing settlement price type
     *
     * @return SettlPriceTypeDecoder : Bitmap field of eight Boolean type indicators representing settlement price type
     */
    public SettlPriceTypeDecoder settlPriceType()
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

    public int clearedVolume()
    {
        return buffer.getInt(offset + 186, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public int openInterestQty()
    {
        return buffer.getInt(offset + 190, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    private final PRICENULLDecoder lowLimitPrice = new PRICENULLDecoder();

    /**
     * Allowable low limit price for the trading day 
     *
     * @return PRICENULLDecoder : Allowable low limit price for the trading day 
     */
    public PRICENULLDecoder lowLimitPrice()
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

    private final PRICENULLDecoder highLimitPrice = new PRICENULLDecoder();

    /**
     * Allowable high limit price for the trading day
     *
     * @return PRICENULLDecoder : Allowable high limit price for the trading day
     */
    public PRICENULLDecoder highLimitPrice()
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

    public byte userDefinedInstrument()
    {
        return buffer.getByte(offset + 210);
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

    public int tradingReferenceDate()
    {
        if (parentMessage.actingVersion < 6)
        {
            return 65535;
        }

        return (buffer.getShort(offset + 211, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }


    private final NoEventsDecoder noEvents = new NoEventsDecoder(this);

    public static long noEventsDecoderId()
    {
        return 864;
    }

    public static int noEventsDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of EventType entries
     *
     * @return NoEventsDecoder : Number of EventType entries
     */
    public NoEventsDecoder noEvents()
    {
        noEvents.wrap(buffer);
        return noEvents;
    }

    /**
     * Number of EventType entries
     */

    public static final class NoEventsDecoder
        implements Iterable<NoEventsDecoder>, java.util.Iterator<NoEventsDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoEventsDecoder(final MDInstrumentDefinitionOption41Decoder parentMessage)
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

        public NoEventsDecoder next()
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
            return 9;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoEventsDecoder> iterator()
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

        public short eventTypeRaw()
        {
            return ((short)(buffer.getByte(offset + 0) & 0xFF));
        }

        public EventType eventType()
        {
            return EventType.get(((short)(buffer.getByte(offset + 0) & 0xFF)));
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

        public long eventTime()
        {
            return buffer.getLong(offset + 1, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("eventType=");
            builder.append(eventType());
            builder.append('|');
            builder.append("eventTime=");
            builder.append(eventTime());
            builder.append(')');

            return builder;
        }
        
        public NoEventsDecoder sbeSkip()
        {

            return this;
        }
    }

    private final NoMDFeedTypesDecoder noMDFeedTypes = new NoMDFeedTypesDecoder(this);

    public static long noMDFeedTypesDecoderId()
    {
        return 1141;
    }

    public static int noMDFeedTypesDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of FeedType entries
     *
     * @return NoMDFeedTypesDecoder : Number of FeedType entries
     */
    public NoMDFeedTypesDecoder noMDFeedTypes()
    {
        noMDFeedTypes.wrap(buffer);
        return noMDFeedTypes;
    }

    /**
     * Number of FeedType entries
     */

    public static final class NoMDFeedTypesDecoder
        implements Iterable<NoMDFeedTypesDecoder>, java.util.Iterator<NoMDFeedTypesDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoMDFeedTypesDecoder(final MDInstrumentDefinitionOption41Decoder parentMessage)
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

        public NoMDFeedTypesDecoder next()
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
            return 4;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoMDFeedTypesDecoder> iterator()
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


        public byte mDFeedType(final int index)
        {
            if (index < 0 || index >= 3)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 0 + (index * 1);

            return buffer.getByte(pos);
        }


        public static String mDFeedTypeCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public int getMDFeedType(final byte[] dst, final int dstOffset)
        {
            final int length = 3;
            if (dstOffset < 0 || dstOffset > (dst.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
            }

            buffer.getBytes(offset + 0, dst, dstOffset, length);

            return length;
        }

        public String mDFeedType()
        {
            final byte[] dst = new byte[3];
            buffer.getBytes(offset + 0, dst, 0, 3);

            int end = 0;
            for (; end < 3 && dst[end] != 0; ++end);

            return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
        }


        public int getMDFeedType(final Appendable value)
        {
            for (int i = 0; i < 3; ++i)
            {
                final int c = buffer.getByte(offset + 0 + i) & 0xFF;
                if (c == 0)
                {
                    return i;
                }

                try
                {
                    value.append(c > 127 ? '?' : (char)c);
                }
                catch (final java.io.IOException ex)
                {
                    throw new java.io.UncheckedIOException(ex);
                }
            }

            return 3;
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

        public byte marketDepth()
        {
            return buffer.getByte(offset + 3);
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("mDFeedType=");
            for (int i = 0; i < mDFeedTypeLength() && mDFeedType(i) > 0; i++)
            {
                builder.append((char)mDFeedType(i));
            }
            builder.append('|');
            builder.append("marketDepth=");
            builder.append(marketDepth());
            builder.append(')');

            return builder;
        }
        
        public NoMDFeedTypesDecoder sbeSkip()
        {

            return this;
        }
    }

    private final NoInstAttribDecoder noInstAttrib = new NoInstAttribDecoder(this);

    public static long noInstAttribDecoderId()
    {
        return 870;
    }

    public static int noInstAttribDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of InstrAttribType entries
     *
     * @return NoInstAttribDecoder : Number of InstrAttribType entries
     */
    public NoInstAttribDecoder noInstAttrib()
    {
        noInstAttrib.wrap(buffer);
        return noInstAttrib;
    }

    /**
     * Number of InstrAttribType entries
     */

    public static final class NoInstAttribDecoder
        implements Iterable<NoInstAttribDecoder>, java.util.Iterator<NoInstAttribDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoInstAttribDecoder(final MDInstrumentDefinitionOption41Decoder parentMessage)
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

        public NoInstAttribDecoder next()
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
            return 4;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoInstAttribDecoder> iterator()
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

        private final InstAttribValueDecoder instAttribValue = new InstAttribValueDecoder();

        /**
         * Bitmap field of 32 Boolean type Instrument eligibility flags
         *
         * @return InstAttribValueDecoder : Bitmap field of 32 Boolean type Instrument eligibility flags
         */
        public InstAttribValueDecoder instAttribValue()
        {
            instAttribValue.wrap(buffer, offset + 0);
            return instAttribValue;
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("instAttribValue=");
            instAttribValue().appendTo(builder);
            builder.append(')');

            return builder;
        }
        
        public NoInstAttribDecoder sbeSkip()
        {

            return this;
        }
    }

    private final NoLotTypeRulesDecoder noLotTypeRules = new NoLotTypeRulesDecoder(this);

    public static long noLotTypeRulesDecoderId()
    {
        return 1234;
    }

    public static int noLotTypeRulesDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of entries
     *
     * @return NoLotTypeRulesDecoder : Number of entries
     */
    public NoLotTypeRulesDecoder noLotTypeRules()
    {
        noLotTypeRules.wrap(buffer);
        return noLotTypeRules;
    }

    /**
     * Number of entries
     */

    public static final class NoLotTypeRulesDecoder
        implements Iterable<NoLotTypeRulesDecoder>, java.util.Iterator<NoLotTypeRulesDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoLotTypeRulesDecoder(final MDInstrumentDefinitionOption41Decoder parentMessage)
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

        public NoLotTypeRulesDecoder next()
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
            return 5;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoLotTypeRulesDecoder> iterator()
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

        public byte lotType()
        {
            return buffer.getByte(offset + 0);
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

        private final DecimalQtyDecoder minLotSize = new DecimalQtyDecoder();

        /**
         * Minimum quantity accepted for order entry. If tag 1093-LotType=4, this value is the minimum quantity for order entry expressed in the applicable units, specified in tag 996-UnitOfMeasure, e.g. megawatts
         *
         * @return DecimalQtyDecoder : Minimum quantity accepted for order entry. If tag 1093-LotType=4, this value is the minimum quantity for order entry expressed in the applicable units, specified in tag 996-UnitOfMeasure, e.g. megawatts
         */
        public DecimalQtyDecoder minLotSize()
        {
            minLotSize.wrap(buffer, offset + 1);
            return minLotSize;
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("lotType=");
            builder.append(lotType());
            builder.append('|');
            builder.append("minLotSize=");
            final DecimalQtyDecoder minLotSize = minLotSize();
            if (minLotSize != null)
            {
                minLotSize.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append(')');

            return builder;
        }
        
        public NoLotTypeRulesDecoder sbeSkip()
        {

            return this;
        }
    }

    private final NoUnderlyingsDecoder noUnderlyings = new NoUnderlyingsDecoder(this);

    public static long noUnderlyingsDecoderId()
    {
        return 711;
    }

    public static int noUnderlyingsDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of underlying instruments
     *
     * @return NoUnderlyingsDecoder : Number of underlying instruments
     */
    public NoUnderlyingsDecoder noUnderlyings()
    {
        noUnderlyings.wrap(buffer);
        return noUnderlyings;
    }

    /**
     * Number of underlying instruments
     */

    public static final class NoUnderlyingsDecoder
        implements Iterable<NoUnderlyingsDecoder>, java.util.Iterator<NoUnderlyingsDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoUnderlyingsDecoder(final MDInstrumentDefinitionOption41Decoder parentMessage)
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

        public NoUnderlyingsDecoder next()
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
            return 24;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoUnderlyingsDecoder> iterator()
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

        public int underlyingSecurityID()
        {
            return buffer.getInt(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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


        public byte underlyingSymbol(final int index)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 4 + (index * 1);

            return buffer.getByte(pos);
        }


        public static String underlyingSymbolCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public int getUnderlyingSymbol(final byte[] dst, final int dstOffset)
        {
            final int length = 20;
            if (dstOffset < 0 || dstOffset > (dst.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
            }

            buffer.getBytes(offset + 4, dst, dstOffset, length);

            return length;
        }

        public String underlyingSymbol()
        {
            final byte[] dst = new byte[20];
            buffer.getBytes(offset + 4, dst, 0, 20);

            int end = 0;
            for (; end < 20 && dst[end] != 0; ++end);

            return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
        }


        public int getUnderlyingSymbol(final Appendable value)
        {
            for (int i = 0; i < 20; ++i)
            {
                final int c = buffer.getByte(offset + 4 + i) & 0xFF;
                if (c == 0)
                {
                    return i;
                }

                try
                {
                    value.append(c > 127 ? '?' : (char)c);
                }
                catch (final java.io.IOException ex)
                {
                    throw new java.io.UncheckedIOException(ex);
                }
            }

            return 20;
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("underlyingSecurityID=");
            builder.append(underlyingSecurityID());
            builder.append('|');
            builder.append("underlyingSymbol=");
            for (int i = 0; i < underlyingSymbolLength() && underlyingSymbol(i) > 0; i++)
            {
                builder.append((char)underlyingSymbol(i));
            }
            builder.append(')');

            return builder;
        }
        
        public NoUnderlyingsDecoder sbeSkip()
        {

            return this;
        }
    }

    private final NoRelatedInstrumentsDecoder noRelatedInstruments = new NoRelatedInstrumentsDecoder(this);

    public static long noRelatedInstrumentsDecoderId()
    {
        return 1647;
    }

    public static int noRelatedInstrumentsDecoderSinceVersion()
    {
        return 7;
    }

    /**
     * Number of related instruments group
     *
     * @return NoRelatedInstrumentsDecoder : Number of related instruments group
     */
    public NoRelatedInstrumentsDecoder noRelatedInstruments()
    {
        if (parentMessage.actingVersion < 7)
        {
            noRelatedInstruments.count = 0;
            noRelatedInstruments.index = 0;
            return noRelatedInstruments;
        }

        noRelatedInstruments.wrap(buffer);
        return noRelatedInstruments;
    }

    /**
     * Number of related instruments group
     */

    public static final class NoRelatedInstrumentsDecoder
        implements Iterable<NoRelatedInstrumentsDecoder>, java.util.Iterator<NoRelatedInstrumentsDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionOption41Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoRelatedInstrumentsDecoder(final MDInstrumentDefinitionOption41Decoder parentMessage)
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

        public NoRelatedInstrumentsDecoder next()
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
            return 24;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoRelatedInstrumentsDecoder> iterator()
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

        public int relatedSecurityID()
        {
            return buffer.getInt(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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


        public byte relatedSymbol(final int index)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 4 + (index * 1);

            return buffer.getByte(pos);
        }


        public static String relatedSymbolCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public int getRelatedSymbol(final byte[] dst, final int dstOffset)
        {
            final int length = 20;
            if (dstOffset < 0 || dstOffset > (dst.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
            }

            buffer.getBytes(offset + 4, dst, dstOffset, length);

            return length;
        }

        public String relatedSymbol()
        {
            final byte[] dst = new byte[20];
            buffer.getBytes(offset + 4, dst, 0, 20);

            int end = 0;
            for (; end < 20 && dst[end] != 0; ++end);

            return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
        }


        public int getRelatedSymbol(final Appendable value)
        {
            for (int i = 0; i < 20; ++i)
            {
                final int c = buffer.getByte(offset + 4 + i) & 0xFF;
                if (c == 0)
                {
                    return i;
                }

                try
                {
                    value.append(c > 127 ? '?' : (char)c);
                }
                catch (final java.io.IOException ex)
                {
                    throw new java.io.UncheckedIOException(ex);
                }
            }

            return 20;
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("relatedSecurityID=");
            builder.append(relatedSecurityID());
            builder.append('|');
            builder.append("relatedSymbol=");
            for (int i = 0; i < relatedSymbolLength() && relatedSymbol(i) > 0; i++)
            {
                builder.append((char)relatedSymbol(i));
            }
            builder.append(')');

            return builder;
        }
        
        public NoRelatedInstrumentsDecoder sbeSkip()
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

        final MDInstrumentDefinitionOption41Decoder decoder = new MDInstrumentDefinitionOption41Decoder();
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
        builder.append("[MDInstrumentDefinitionOption41](sbeTemplateId=");
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
        builder.append("matchEventIndicator=");
        matchEventIndicator().appendTo(builder);
        builder.append('|');
        builder.append("totNumReports=");
        builder.append(totNumReports());
        builder.append('|');
        builder.append("securityUpdateAction=");
        builder.append(securityUpdateAction());
        builder.append('|');
        builder.append("lastUpdateTime=");
        builder.append(lastUpdateTime());
        builder.append('|');
        builder.append("mDSecurityTradingStatus=");
        builder.append(mDSecurityTradingStatus());
        builder.append('|');
        builder.append("applID=");
        builder.append(applID());
        builder.append('|');
        builder.append("marketSegmentID=");
        builder.append(marketSegmentID());
        builder.append('|');
        builder.append("underlyingProduct=");
        builder.append(underlyingProduct());
        builder.append('|');
        builder.append("securityExchange=");
        for (int i = 0; i < securityExchangeLength() && securityExchange(i) > 0; i++)
        {
            builder.append((char)securityExchange(i));
        }
        builder.append('|');
        builder.append("securityGroup=");
        for (int i = 0; i < securityGroupLength() && securityGroup(i) > 0; i++)
        {
            builder.append((char)securityGroup(i));
        }
        builder.append('|');
        builder.append("asset=");
        for (int i = 0; i < assetLength() && asset(i) > 0; i++)
        {
            builder.append((char)asset(i));
        }
        builder.append('|');
        builder.append("symbol=");
        for (int i = 0; i < symbolLength() && symbol(i) > 0; i++)
        {
            builder.append((char)symbol(i));
        }
        builder.append('|');
        builder.append("securityID=");
        builder.append(securityID());
        builder.append('|');
        builder.append("securityType=");
        for (int i = 0; i < securityTypeLength() && securityType(i) > 0; i++)
        {
            builder.append((char)securityType(i));
        }
        builder.append('|');
        builder.append("cFICode=");
        for (int i = 0; i < cFICodeLength() && cFICode(i) > 0; i++)
        {
            builder.append((char)cFICode(i));
        }
        builder.append('|');
        builder.append("putOrCall=");
        builder.append(putOrCall());
        builder.append('|');
        builder.append("maturityMonthYear=");
        final MaturityMonthYearDecoder maturityMonthYear = maturityMonthYear();
        if (maturityMonthYear != null)
        {
            maturityMonthYear.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("currency=");
        for (int i = 0; i < currencyLength() && currency(i) > 0; i++)
        {
            builder.append((char)currency(i));
        }
        builder.append('|');
        builder.append("strikePrice=");
        final PRICENULLDecoder strikePrice = strikePrice();
        if (strikePrice != null)
        {
            strikePrice.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("strikeCurrency=");
        for (int i = 0; i < strikeCurrencyLength() && strikeCurrency(i) > 0; i++)
        {
            builder.append((char)strikeCurrency(i));
        }
        builder.append('|');
        builder.append("settlCurrency=");
        for (int i = 0; i < settlCurrencyLength() && settlCurrency(i) > 0; i++)
        {
            builder.append((char)settlCurrency(i));
        }
        builder.append('|');
        builder.append("minCabPrice=");
        final PRICENULLDecoder minCabPrice = minCabPrice();
        if (minCabPrice != null)
        {
            minCabPrice.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("matchAlgorithm=");
        builder.append(matchAlgorithm());
        builder.append('|');
        builder.append("minTradeVol=");
        builder.append(minTradeVol());
        builder.append('|');
        builder.append("maxTradeVol=");
        builder.append(maxTradeVol());
        builder.append('|');
        builder.append("minPriceIncrement=");
        final PRICENULLDecoder minPriceIncrement = minPriceIncrement();
        if (minPriceIncrement != null)
        {
            minPriceIncrement.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("minPriceIncrementAmount=");
        final PRICENULLDecoder minPriceIncrementAmount = minPriceIncrementAmount();
        if (minPriceIncrementAmount != null)
        {
            minPriceIncrementAmount.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("displayFactor=");
        final FLOATDecoder displayFactor = displayFactor();
        if (displayFactor != null)
        {
            displayFactor.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("tickRule=");
        builder.append(tickRule());
        builder.append('|');
        builder.append("mainFraction=");
        builder.append(mainFraction());
        builder.append('|');
        builder.append("subFraction=");
        builder.append(subFraction());
        builder.append('|');
        builder.append("priceDisplayFormat=");
        builder.append(priceDisplayFormat());
        builder.append('|');
        builder.append("unitOfMeasure=");
        for (int i = 0; i < unitOfMeasureLength() && unitOfMeasure(i) > 0; i++)
        {
            builder.append((char)unitOfMeasure(i));
        }
        builder.append('|');
        builder.append("unitOfMeasureQty=");
        final PRICENULLDecoder unitOfMeasureQty = unitOfMeasureQty();
        if (unitOfMeasureQty != null)
        {
            unitOfMeasureQty.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("tradingReferencePrice=");
        final PRICENULLDecoder tradingReferencePrice = tradingReferencePrice();
        if (tradingReferencePrice != null)
        {
            tradingReferencePrice.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("settlPriceType=");
        settlPriceType().appendTo(builder);
        builder.append('|');
        builder.append("clearedVolume=");
        builder.append(clearedVolume());
        builder.append('|');
        builder.append("openInterestQty=");
        builder.append(openInterestQty());
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
        builder.append("userDefinedInstrument=");
        builder.append(userDefinedInstrument());
        builder.append('|');
        builder.append("tradingReferenceDate=");
        builder.append(tradingReferenceDate());
        builder.append('|');
        builder.append("noEvents=[");
        final int noEventsOriginalOffset = noEvents.offset;
        final int noEventsOriginalIndex = noEvents.index;
        final NoEventsDecoder noEvents = noEvents();
        if (noEvents.count() > 0)
        {
            while (noEvents.hasNext())
            {
                noEvents.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noEvents.offset = noEventsOriginalOffset;
        noEvents.index = noEventsOriginalIndex;
        builder.append(']');
        builder.append('|');
        builder.append("noMDFeedTypes=[");
        final int noMDFeedTypesOriginalOffset = noMDFeedTypes.offset;
        final int noMDFeedTypesOriginalIndex = noMDFeedTypes.index;
        final NoMDFeedTypesDecoder noMDFeedTypes = noMDFeedTypes();
        if (noMDFeedTypes.count() > 0)
        {
            while (noMDFeedTypes.hasNext())
            {
                noMDFeedTypes.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noMDFeedTypes.offset = noMDFeedTypesOriginalOffset;
        noMDFeedTypes.index = noMDFeedTypesOriginalIndex;
        builder.append(']');
        builder.append('|');
        builder.append("noInstAttrib=[");
        final int noInstAttribOriginalOffset = noInstAttrib.offset;
        final int noInstAttribOriginalIndex = noInstAttrib.index;
        final NoInstAttribDecoder noInstAttrib = noInstAttrib();
        if (noInstAttrib.count() > 0)
        {
            while (noInstAttrib.hasNext())
            {
                noInstAttrib.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noInstAttrib.offset = noInstAttribOriginalOffset;
        noInstAttrib.index = noInstAttribOriginalIndex;
        builder.append(']');
        builder.append('|');
        builder.append("noLotTypeRules=[");
        final int noLotTypeRulesOriginalOffset = noLotTypeRules.offset;
        final int noLotTypeRulesOriginalIndex = noLotTypeRules.index;
        final NoLotTypeRulesDecoder noLotTypeRules = noLotTypeRules();
        if (noLotTypeRules.count() > 0)
        {
            while (noLotTypeRules.hasNext())
            {
                noLotTypeRules.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noLotTypeRules.offset = noLotTypeRulesOriginalOffset;
        noLotTypeRules.index = noLotTypeRulesOriginalIndex;
        builder.append(']');
        builder.append('|');
        builder.append("noUnderlyings=[");
        final int noUnderlyingsOriginalOffset = noUnderlyings.offset;
        final int noUnderlyingsOriginalIndex = noUnderlyings.index;
        final NoUnderlyingsDecoder noUnderlyings = noUnderlyings();
        if (noUnderlyings.count() > 0)
        {
            while (noUnderlyings.hasNext())
            {
                noUnderlyings.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noUnderlyings.offset = noUnderlyingsOriginalOffset;
        noUnderlyings.index = noUnderlyingsOriginalIndex;
        builder.append(']');
        builder.append('|');
        builder.append("noRelatedInstruments=[");
        final int noRelatedInstrumentsOriginalOffset = noRelatedInstruments.offset;
        final int noRelatedInstrumentsOriginalIndex = noRelatedInstruments.index;
        final NoRelatedInstrumentsDecoder noRelatedInstruments = noRelatedInstruments();
        if (noRelatedInstruments.count() > 0)
        {
            while (noRelatedInstruments.hasNext())
            {
                noRelatedInstruments.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noRelatedInstruments.offset = noRelatedInstrumentsOriginalOffset;
        noRelatedInstruments.index = noRelatedInstrumentsOriginalIndex;
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
    
    public MDInstrumentDefinitionOption41Decoder sbeSkip()
    {
        sbeRewind();
        NoEventsDecoder noEvents = noEvents();
        if (noEvents.count() > 0)
        {
            while (noEvents.hasNext())
            {
                noEvents.next();
                noEvents.sbeSkip();
            }
        }
        NoMDFeedTypesDecoder noMDFeedTypes = noMDFeedTypes();
        if (noMDFeedTypes.count() > 0)
        {
            while (noMDFeedTypes.hasNext())
            {
                noMDFeedTypes.next();
                noMDFeedTypes.sbeSkip();
            }
        }
        NoInstAttribDecoder noInstAttrib = noInstAttrib();
        if (noInstAttrib.count() > 0)
        {
            while (noInstAttrib.hasNext())
            {
                noInstAttrib.next();
                noInstAttrib.sbeSkip();
            }
        }
        NoLotTypeRulesDecoder noLotTypeRules = noLotTypeRules();
        if (noLotTypeRules.count() > 0)
        {
            while (noLotTypeRules.hasNext())
            {
                noLotTypeRules.next();
                noLotTypeRules.sbeSkip();
            }
        }
        NoUnderlyingsDecoder noUnderlyings = noUnderlyings();
        if (noUnderlyings.count() > 0)
        {
            while (noUnderlyings.hasNext())
            {
                noUnderlyings.next();
                noUnderlyings.sbeSkip();
            }
        }
        NoRelatedInstrumentsDecoder noRelatedInstruments = noRelatedInstruments();
        if (noRelatedInstruments.count() > 0)
        {
            while (noRelatedInstruments.hasNext())
            {
                noRelatedInstruments.next();
                noRelatedInstruments.sbeSkip();
            }
        }

        return this;
    }
}
