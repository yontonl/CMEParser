/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;


/**
 * AdminLogin
 */
@SuppressWarnings("all")
public final class AdminLogin15Encoder implements MessageEncoderFlyweight
{
    public static final int BLOCK_LENGTH = 1;
    public static final int TEMPLATE_ID = 15;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final AdminLogin15Encoder parentMessage = this;
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
        return "A";
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

    public AdminLogin15Encoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public AdminLogin15Encoder wrapAndApplyHeader(
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

    public static int heartBtIntId()
    {
        return 108;
    }

    public static int heartBtIntSinceVersion()
    {
        return 0;
    }

    public static int heartBtIntEncodingOffset()
    {
        return 0;
    }

    public static int heartBtIntEncodingLength()
    {
        return 1;
    }

    public static String heartBtIntMetaAttribute(final MetaAttribute metaAttribute)
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

    public static byte heartBtIntNullValue()
    {
        return (byte)-128;
    }

    public static byte heartBtIntMinValue()
    {
        return (byte)-127;
    }

    public static byte heartBtIntMaxValue()
    {
        return (byte)127;
    }

    public AdminLogin15Encoder heartBtInt(final byte value)
    {
        buffer.putByte(offset + 0, value);
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

        final AdminLogin15Decoder decoder = new AdminLogin15Decoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
