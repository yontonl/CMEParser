/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.DirectBuffer;
import org.agrona.sbe.*;

@SuppressWarnings("all")
public final class MatchEventIndicatorDecoder implements Flyweight
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final int ENCODED_LENGTH = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private DirectBuffer buffer;

    public MatchEventIndicatorDecoder wrap(final DirectBuffer buffer, final int offset)
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

    public boolean isEmpty()
    {
        return 0 == buffer.getByte(offset);
    }

    public short getRaw()
    {
        return ((short)(buffer.getByte(offset) & 0xFF));
    }
    /**
     * 1=Last trade message for the event, 0=Not last
     *
     * @return true if LastTradeMsg set or false if not.
     */

    public boolean lastTradeMsg()
    {
        return 0 != (buffer.getByte(offset) & (1 << 0));
    }

    public static boolean lastTradeMsg(final byte value)
    {
        return 0 != (value & (1 << 0));
    }
    /**
     * 1=Last electronic volume message, 0=Not last
     *
     * @return true if LastVolumeMsg set or false if not.
     */

    public boolean lastVolumeMsg()
    {
        return 0 != (buffer.getByte(offset) & (1 << 1));
    }

    public static boolean lastVolumeMsg(final byte value)
    {
        return 0 != (value & (1 << 1));
    }
    /**
     * 1=Last real quote message, 0=Not last
     *
     * @return true if LastQuoteMsg set or false if not.
     */

    public boolean lastQuoteMsg()
    {
        return 0 != (buffer.getByte(offset) & (1 << 2));
    }

    public static boolean lastQuoteMsg(final byte value)
    {
        return 0 != (value & (1 << 2));
    }
    /**
     * 1=Last statistics message, 0=Not last
     *
     * @return true if LastStatsMsg set or false if not.
     */

    public boolean lastStatsMsg()
    {
        return 0 != (buffer.getByte(offset) & (1 << 3));
    }

    public static boolean lastStatsMsg(final byte value)
    {
        return 0 != (value & (1 << 3));
    }
    /**
     * 1=Last implied quote message, 0=Not last
     *
     * @return true if LastImpliedMsg set or false if not.
     */

    public boolean lastImpliedMsg()
    {
        return 0 != (buffer.getByte(offset) & (1 << 4));
    }

    public static boolean lastImpliedMsg(final byte value)
    {
        return 0 != (value & (1 << 4));
    }
    /**
     * 1=Message is sent during  recovery process
     *
     * @return true if RecoveryMsg set or false if not.
     */

    public boolean recoveryMsg()
    {
        return 0 != (buffer.getByte(offset) & (1 << 5));
    }

    public static boolean recoveryMsg(final byte value)
    {
        return 0 != (value & (1 << 5));
    }
    /**
     * 0=Reserved for future use
     *
     * @return true if Reserved set or false if not.
     */

    public boolean reserved()
    {
        return 0 != (buffer.getByte(offset) & (1 << 6));
    }

    public static boolean reserved(final byte value)
    {
        return 0 != (value & (1 << 6));
    }
    /**
     * 1=Last message for the event, 0=Not last
     *
     * @return true if EndOfEvent set or false if not.
     */

    public boolean endOfEvent()
    {
        return 0 != (buffer.getByte(offset) & (1 << 7));
    }

    public static boolean endOfEvent(final byte value)
    {
        return 0 != (value & (1 << 7));
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
        builder.append('{');
        boolean atLeastOne = false;
        if (lastTradeMsg())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("lastTradeMsg");
            atLeastOne = true;
        }
        if (lastVolumeMsg())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("lastVolumeMsg");
            atLeastOne = true;
        }
        if (lastQuoteMsg())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("lastQuoteMsg");
            atLeastOne = true;
        }
        if (lastStatsMsg())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("lastStatsMsg");
            atLeastOne = true;
        }
        if (lastImpliedMsg())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("lastImpliedMsg");
            atLeastOne = true;
        }
        if (recoveryMsg())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("recoveryMsg");
            atLeastOne = true;
        }
        if (reserved())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("reserved");
            atLeastOne = true;
        }
        if (endOfEvent())
        {
            if (atLeastOne)
            {
                builder.append(',');
            }
            builder.append("endOfEvent");
            atLeastOne = true;
        }
        builder.append('}');

        return builder;
    }
}
