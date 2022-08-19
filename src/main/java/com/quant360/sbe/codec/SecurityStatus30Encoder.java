/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;


/**
 * SecurityStatus
 */
@SuppressWarnings("all")
public final class SecurityStatus30Encoder implements MessageEncoderFlyweight
{
    public static final int BLOCK_LENGTH = 30;
    public static final int TEMPLATE_ID = 30;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final SecurityStatus30Encoder parentMessage = this;
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
        return "f";
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

    public SecurityStatus30Encoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public SecurityStatus30Encoder wrapAndApplyHeader(
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

    public SecurityStatus30Encoder transactTime(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 8;
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


    public SecurityStatus30Encoder securityGroup(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 8 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String securityGroupCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public SecurityStatus30Encoder putSecurityGroup(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 8, src, srcOffset, length);

        return this;
    }

    public SecurityStatus30Encoder securityGroup(final String src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 8, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 8 + start, (byte)0);
        }

        return this;
    }

    public SecurityStatus30Encoder securityGroup(final CharSequence src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 8, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 8 + start, (byte)0);
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
        return 14;
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


    public SecurityStatus30Encoder asset(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 14 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String assetCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public SecurityStatus30Encoder putAsset(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(offset + 14, src, srcOffset, length);

        return this;
    }

    public SecurityStatus30Encoder asset(final String src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 14, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 14 + start, (byte)0);
        }

        return this;
    }

    public SecurityStatus30Encoder asset(final CharSequence src)
    {
        final int length = 6;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(offset + 14, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(offset + 14 + start, (byte)0);
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
        return 20;
    }

    public static int securityIDEncodingLength()
    {
        return 4;
    }

    public static String securityIDMetaAttribute(final MetaAttribute metaAttribute)
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

    public static int securityIDNullValue()
    {
        return 2147483647;
    }

    public static int securityIDMinValue()
    {
        return -2147483647;
    }

    public static int securityIDMaxValue()
    {
        return 2147483647;
    }

    public SecurityStatus30Encoder securityID(final int value)
    {
        buffer.putInt(offset + 20, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 24;
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

    public SecurityStatus30Encoder tradeDate(final int value)
    {
        buffer.putShort(offset + 24, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        return 26;
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
        matchEventIndicator.wrap(buffer, offset + 26);
        return matchEventIndicator;
    }

    public static int securityTradingStatusId()
    {
        return 326;
    }

    public static int securityTradingStatusSinceVersion()
    {
        return 0;
    }

    public static int securityTradingStatusEncodingOffset()
    {
        return 27;
    }

    public static int securityTradingStatusEncodingLength()
    {
        return 1;
    }

    public static String securityTradingStatusMetaAttribute(final MetaAttribute metaAttribute)
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

    public SecurityStatus30Encoder securityTradingStatus(final SecurityTradingStatus value)
    {
        buffer.putByte(offset + 27, (byte)value.value());
        return this;
    }

    public static int haltReasonId()
    {
        return 327;
    }

    public static int haltReasonSinceVersion()
    {
        return 0;
    }

    public static int haltReasonEncodingOffset()
    {
        return 28;
    }

    public static int haltReasonEncodingLength()
    {
        return 1;
    }

    public static String haltReasonMetaAttribute(final MetaAttribute metaAttribute)
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

    public SecurityStatus30Encoder haltReason(final HaltReason value)
    {
        buffer.putByte(offset + 28, (byte)value.value());
        return this;
    }

    public static int securityTradingEventId()
    {
        return 1174;
    }

    public static int securityTradingEventSinceVersion()
    {
        return 0;
    }

    public static int securityTradingEventEncodingOffset()
    {
        return 29;
    }

    public static int securityTradingEventEncodingLength()
    {
        return 1;
    }

    public static String securityTradingEventMetaAttribute(final MetaAttribute metaAttribute)
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

    public SecurityStatus30Encoder securityTradingEvent(final SecurityTradingEvent value)
    {
        buffer.putByte(offset + 29, (byte)value.value());
        return this;
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

        final SecurityStatus30Decoder decoder = new SecurityStatus30Decoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
