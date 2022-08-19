/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.DirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    MDInstrumentDefinitionSpread29Decoder.NoEventsDecoder.class,
    MDInstrumentDefinitionSpread29Decoder.NoMDFeedTypesDecoder.class,
    MDInstrumentDefinitionSpread29Decoder.NoInstAttribDecoder.class,
    MDInstrumentDefinitionSpread29Decoder.NoLotTypeRulesDecoder.class,
    MDInstrumentDefinitionSpread29Decoder.NoLegsDecoder.class})
/**
 * MDInstrumentDefinitionSpread
 */
@SuppressWarnings("all")
public final class MDInstrumentDefinitionSpread29Decoder implements MessageDecoderFlyweight
{
    public static final int BLOCK_LENGTH = 195;
    public static final int TEMPLATE_ID = 29;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final MDInstrumentDefinitionSpread29Decoder parentMessage = this;
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

    public MDInstrumentDefinitionSpread29Decoder wrap(
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

    public MDInstrumentDefinitionSpread29Decoder wrapAndApplyHeader(
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

    public MDInstrumentDefinitionSpread29Decoder sbeRewind()
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
            return "optional";
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
        return 71;
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
        maturityMonthYear.wrap(buffer, offset + 71);
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
        return 76;
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

        final int pos = offset + 76 + (index * 1);

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

        buffer.getBytes(offset + 76, dst, dstOffset, length);

        return length;
    }

    public String currency()
    {
        final byte[] dst = new byte[3];
        buffer.getBytes(offset + 76, dst, 0, 3);

        int end = 0;
        for (; end < 3 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getCurrency(final Appendable value)
    {
        for (int i = 0; i < 3; ++i)
        {
            final int c = buffer.getByte(offset + 76 + i) & 0xFF;
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


    public static int securitySubTypeId()
    {
        return 762;
    }

    public static int securitySubTypeSinceVersion()
    {
        return 0;
    }

    public static int securitySubTypeEncodingOffset()
    {
        return 79;
    }

    public static int securitySubTypeEncodingLength()
    {
        return 5;
    }

    public static String securitySubTypeMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte securitySubTypeNullValue()
    {
        return (byte)0;
    }

    public static byte securitySubTypeMinValue()
    {
        return (byte)32;
    }

    public static byte securitySubTypeMaxValue()
    {
        return (byte)126;
    }

    public static int securitySubTypeLength()
    {
        return 5;
    }


    public byte securitySubType(final int index)
    {
        if (index < 0 || index >= 5)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 79 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String securitySubTypeCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getSecuritySubType(final byte[] dst, final int dstOffset)
    {
        final int length = 5;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 79, dst, dstOffset, length);

        return length;
    }

    public String securitySubType()
    {
        final byte[] dst = new byte[5];
        buffer.getBytes(offset + 79, dst, 0, 5);

        int end = 0;
        for (; end < 5 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSecuritySubType(final Appendable value)
    {
        for (int i = 0; i < 5; ++i)
        {
            final int c = buffer.getByte(offset + 79 + i) & 0xFF;
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

        return 5;
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
        return 84;
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
        return buffer.getByte(offset + 84);
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
        return 85;
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
        return buffer.getByte(offset + 85);
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
        return 86;
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
        return (buffer.getInt(offset + 86, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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
        return 90;
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
        return (buffer.getInt(offset + 90, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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
        return 94;
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

    private final PRICEDecoder minPriceIncrement = new PRICEDecoder();

    /**
     * Minimum constant tick for the instrument, sent only if instrument is non-VTT (Variable Tick table) eligible
     *
     * @return PRICEDecoder : Minimum constant tick for the instrument, sent only if instrument is non-VTT (Variable Tick table) eligible
     */
    public PRICEDecoder minPriceIncrement()
    {
        minPriceIncrement.wrap(buffer, offset + 94);
        return minPriceIncrement;
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
        return 102;
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
        displayFactor.wrap(buffer, offset + 102);
        return displayFactor;
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
        return 110;
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
        return ((short)(buffer.getByte(offset + 110) & 0xFF));
    }


    public static int priceRatioId()
    {
        return 5770;
    }

    public static int priceRatioSinceVersion()
    {
        return 0;
    }

    public static int priceRatioEncodingOffset()
    {
        return 111;
    }

    public static int priceRatioEncodingLength()
    {
        return 8;
    }

    public static String priceRatioMetaAttribute(final MetaAttribute metaAttribute)
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

    private final PRICENULLDecoder priceRatio = new PRICENULLDecoder();

    /**
     * Used for price calculation in spread and leg pricing
     *
     * @return PRICENULLDecoder : Used for price calculation in spread and leg pricing
     */
    public PRICENULLDecoder priceRatio()
    {
        priceRatio.wrap(buffer, offset + 111);
        return priceRatio;
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
        return 119;
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
        return buffer.getByte(offset + 119);
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
        return 120;
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

        final int pos = offset + 120 + (index * 1);

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

        buffer.getBytes(offset + 120, dst, dstOffset, length);

        return length;
    }

    public String unitOfMeasure()
    {
        final byte[] dst = new byte[30];
        buffer.getBytes(offset + 120, dst, 0, 30);

        int end = 0;
        for (; end < 30 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getUnitOfMeasure(final Appendable value)
    {
        for (int i = 0; i < 30; ++i)
        {
            final int c = buffer.getByte(offset + 120 + i) & 0xFF;
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
        return 150;
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
        tradingReferencePrice.wrap(buffer, offset + 150);
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
        return 158;
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
        settlPriceType.wrap(buffer, offset + 158);
        return settlPriceType;
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
        return 159;
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
        return buffer.getInt(offset + 159, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 163;
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
        return buffer.getInt(offset + 163, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 167;
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
        highLimitPrice.wrap(buffer, offset + 167);
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
        return 175;
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
        lowLimitPrice.wrap(buffer, offset + 175);
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
        return 183;
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
        maxPriceVariation.wrap(buffer, offset + 183);
        return maxPriceVariation;
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
        return 191;
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
        return ((short)(buffer.getByte(offset + 191) & 0xFF));
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
        return 192;
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
        return ((short)(buffer.getByte(offset + 192) & 0xFF));
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
        return 193;
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

        return (buffer.getShort(offset + 193, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
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
     * Number of repeating EventType entries
     *
     * @return NoEventsDecoder : Number of repeating EventType entries
     */
    public NoEventsDecoder noEvents()
    {
        noEvents.wrap(buffer);
        return noEvents;
    }

    /**
     * Number of repeating EventType entries
     */

    public static final class NoEventsDecoder
        implements Iterable<NoEventsDecoder>, java.util.Iterator<NoEventsDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionSpread29Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoEventsDecoder(final MDInstrumentDefinitionSpread29Decoder parentMessage)
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
        private final MDInstrumentDefinitionSpread29Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoMDFeedTypesDecoder(final MDInstrumentDefinitionSpread29Decoder parentMessage)
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
        private final MDInstrumentDefinitionSpread29Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoInstAttribDecoder(final MDInstrumentDefinitionSpread29Decoder parentMessage)
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
        private final MDInstrumentDefinitionSpread29Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoLotTypeRulesDecoder(final MDInstrumentDefinitionSpread29Decoder parentMessage)
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

    private final NoLegsDecoder noLegs = new NoLegsDecoder(this);

    public static long noLegsDecoderId()
    {
        return 555;
    }

    public static int noLegsDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Number of Leg entries
     *
     * @return NoLegsDecoder : Number of Leg entries
     */
    public NoLegsDecoder noLegs()
    {
        noLegs.wrap(buffer);
        return noLegs;
    }

    /**
     * Number of Leg entries
     */

    public static final class NoLegsDecoder
        implements Iterable<NoLegsDecoder>, java.util.Iterator<NoLegsDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final MDInstrumentDefinitionSpread29Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoLegsDecoder(final MDInstrumentDefinitionSpread29Decoder parentMessage)
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

        public NoLegsDecoder next()
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
            return 18;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoLegsDecoder> iterator()
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

        public static int legSecurityIDId()
        {
            return 602;
        }

        public static int legSecurityIDSinceVersion()
        {
            return 0;
        }

        public static int legSecurityIDEncodingOffset()
        {
            return 0;
        }

        public static int legSecurityIDEncodingLength()
        {
            return 4;
        }

        public static String legSecurityIDMetaAttribute(final MetaAttribute metaAttribute)
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

        public static int legSecurityIDNullValue()
        {
            return -2147483648;
        }

        public static int legSecurityIDMinValue()
        {
            return -2147483647;
        }

        public static int legSecurityIDMaxValue()
        {
            return 2147483647;
        }

        public int legSecurityID()
        {
            return buffer.getInt(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int legSecurityIDSourceId()
        {
            return 603;
        }

        public static int legSecurityIDSourceSinceVersion()
        {
            return 0;
        }

        public static int legSecurityIDSourceEncodingOffset()
        {
            return 4;
        }

        public static int legSecurityIDSourceEncodingLength()
        {
            return 0;
        }

        public static String legSecurityIDSourceMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte legSecurityIDSourceNullValue()
        {
            return (byte)0;
        }

        public static byte legSecurityIDSourceMinValue()
        {
            return (byte)32;
        }

        public static byte legSecurityIDSourceMaxValue()
        {
            return (byte)126;
        }


        private static final byte[] LEGSECURITYIDSOURCE_VALUE = { 56 };

        public static int legSecurityIDSourceLength()
        {
            return 1;
        }


        public byte legSecurityIDSource(final int index)
        {
            return LEGSECURITYIDSOURCE_VALUE[index];
        }

        public int getLegSecurityIDSource(final byte[] dst, final int offset, final int length)
        {
            final int bytesCopied = Math.min(length, 1);
            System.arraycopy(LEGSECURITYIDSOURCE_VALUE, 0, dst, offset, bytesCopied);

            return bytesCopied;
        }

        public byte legSecurityIDSource()
        {
            return (byte)56;
        }


        public static int legSideId()
        {
            return 624;
        }

        public static int legSideSinceVersion()
        {
            return 0;
        }

        public static int legSideEncodingOffset()
        {
            return 4;
        }

        public static int legSideEncodingLength()
        {
            return 1;
        }

        public static String legSideMetaAttribute(final MetaAttribute metaAttribute)
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

        public short legSideRaw()
        {
            return ((short)(buffer.getByte(offset + 4) & 0xFF));
        }

        public LegSide legSide()
        {
            return LegSide.get(((short)(buffer.getByte(offset + 4) & 0xFF)));
        }


        public static int legRatioQtyId()
        {
            return 623;
        }

        public static int legRatioQtySinceVersion()
        {
            return 0;
        }

        public static int legRatioQtyEncodingOffset()
        {
            return 5;
        }

        public static int legRatioQtyEncodingLength()
        {
            return 1;
        }

        public static String legRatioQtyMetaAttribute(final MetaAttribute metaAttribute)
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

        public static byte legRatioQtyNullValue()
        {
            return (byte)-128;
        }

        public static byte legRatioQtyMinValue()
        {
            return (byte)-127;
        }

        public static byte legRatioQtyMaxValue()
        {
            return (byte)127;
        }

        public byte legRatioQty()
        {
            return buffer.getByte(offset + 5);
        }


        public static int legPriceId()
        {
            return 566;
        }

        public static int legPriceSinceVersion()
        {
            return 0;
        }

        public static int legPriceEncodingOffset()
        {
            return 6;
        }

        public static int legPriceEncodingLength()
        {
            return 8;
        }

        public static String legPriceMetaAttribute(final MetaAttribute metaAttribute)
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

        private final PRICENULLDecoder legPrice = new PRICENULLDecoder();

        /**
         * Price for the future leg of a UDS Covered instrument 
         *
         * @return PRICENULLDecoder : Price for the future leg of a UDS Covered instrument 
         */
        public PRICENULLDecoder legPrice()
        {
            legPrice.wrap(buffer, offset + 6);
            return legPrice;
        }

        public static int legOptionDeltaId()
        {
            return 1017;
        }

        public static int legOptionDeltaSinceVersion()
        {
            return 0;
        }

        public static int legOptionDeltaEncodingOffset()
        {
            return 14;
        }

        public static int legOptionDeltaEncodingLength()
        {
            return 4;
        }

        public static String legOptionDeltaMetaAttribute(final MetaAttribute metaAttribute)
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

        private final DecimalQtyDecoder legOptionDelta = new DecimalQtyDecoder();

        /**
         * Delta used to calculate the quantity of futures used to cover the option or option strategy
         *
         * @return DecimalQtyDecoder : Delta used to calculate the quantity of futures used to cover the option or option strategy
         */
        public DecimalQtyDecoder legOptionDelta()
        {
            legOptionDelta.wrap(buffer, offset + 14);
            return legOptionDelta;
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("legSecurityID=");
            builder.append(legSecurityID());
            builder.append('|');
            builder.append("legSide=");
            builder.append(legSide());
            builder.append('|');
            builder.append("legRatioQty=");
            builder.append(legRatioQty());
            builder.append('|');
            builder.append("legPrice=");
            final PRICENULLDecoder legPrice = legPrice();
            if (legPrice != null)
            {
                legPrice.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append('|');
            builder.append("legOptionDelta=");
            final DecimalQtyDecoder legOptionDelta = legOptionDelta();
            if (legOptionDelta != null)
            {
                legOptionDelta.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append(')');

            return builder;
        }
        
        public NoLegsDecoder sbeSkip()
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

        final MDInstrumentDefinitionSpread29Decoder decoder = new MDInstrumentDefinitionSpread29Decoder();
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
        builder.append("[MDInstrumentDefinitionSpread29](sbeTemplateId=");
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
        builder.append("securitySubType=");
        for (int i = 0; i < securitySubTypeLength() && securitySubType(i) > 0; i++)
        {
            builder.append((char)securitySubType(i));
        }
        builder.append('|');
        builder.append("userDefinedInstrument=");
        builder.append(userDefinedInstrument());
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
        final PRICEDecoder minPriceIncrement = minPriceIncrement();
        if (minPriceIncrement != null)
        {
            minPriceIncrement.appendTo(builder);
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
        builder.append("priceDisplayFormat=");
        builder.append(priceDisplayFormat());
        builder.append('|');
        builder.append("priceRatio=");
        final PRICENULLDecoder priceRatio = priceRatio();
        if (priceRatio != null)
        {
            priceRatio.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');
        builder.append("tickRule=");
        builder.append(tickRule());
        builder.append('|');
        builder.append("unitOfMeasure=");
        for (int i = 0; i < unitOfMeasureLength() && unitOfMeasure(i) > 0; i++)
        {
            builder.append((char)unitOfMeasure(i));
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
        builder.append("openInterestQty=");
        builder.append(openInterestQty());
        builder.append('|');
        builder.append("clearedVolume=");
        builder.append(clearedVolume());
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
        builder.append("mainFraction=");
        builder.append(mainFraction());
        builder.append('|');
        builder.append("subFraction=");
        builder.append(subFraction());
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
        builder.append("noLegs=[");
        final int noLegsOriginalOffset = noLegs.offset;
        final int noLegsOriginalIndex = noLegs.index;
        final NoLegsDecoder noLegs = noLegs();
        if (noLegs.count() > 0)
        {
            while (noLegs.hasNext())
            {
                noLegs.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noLegs.offset = noLegsOriginalOffset;
        noLegs.index = noLegsOriginalIndex;
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
    
    public MDInstrumentDefinitionSpread29Decoder sbeSkip()
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
        NoLegsDecoder noLegs = noLegs();
        if (noLegs.count() > 0)
        {
            while (noLegs.hasNext())
            {
                noLegs.next();
                noLegs.sbeSkip();
            }
        }

        return this;
    }
}
