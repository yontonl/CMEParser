/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.DirectBuffer;
import org.agrona.sbe.*;


/**
 * 8 Byte aligned repeating group dimensions
 */
@SuppressWarnings("all")
public final class GroupSize8ByteDecoder implements CompositeDecoderFlyweight
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final int ENCODED_LENGTH = 8;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private DirectBuffer buffer;

    public GroupSize8ByteDecoder wrap(final DirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;

        return this;
    }

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public int encodedLength()
    {
        return ENCODED_LENGTH;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public static int blockLengthEncodingOffset()
    {
        return 0;
    }

    public static int blockLengthEncodingLength()
    {
        return 2;
    }

    public static int blockLengthSinceVersion()
    {
        return 0;
    }

    public static int blockLengthNullValue()
    {
        return 65535;
    }

    public static int blockLengthMinValue()
    {
        return 0;
    }

    public static int blockLengthMaxValue()
    {
        return 65534;
    }

    public int blockLength()
    {
        return (buffer.getShort(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }


    public static int numInGroupEncodingOffset()
    {
        return 7;
    }

    public static int numInGroupEncodingLength()
    {
        return 1;
    }

    public static int numInGroupSinceVersion()
    {
        return 0;
    }

    public static short numInGroupNullValue()
    {
        return (short)255;
    }

    public static short numInGroupMinValue()
    {
        return (short)0;
    }

    public static short numInGroupMaxValue()
    {
        return (short)254;
    }

    public short numInGroup()
    {
        return ((short)(buffer.getByte(offset + 7) & 0xFF));
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

        builder.append('(');
        builder.append("blockLength=");
        builder.append(blockLength());
        builder.append('|');
        builder.append("numInGroup=");
        builder.append(numInGroup());
        builder.append(')');

        return builder;
    }
}
