/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.MutableDirectBuffer;
import org.agrona.sbe.*;

@SuppressWarnings("all")
public final class MatchEventIndicatorEncoder implements Flyweight
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final int ENCODED_LENGTH = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private MutableDirectBuffer buffer;

    public MatchEventIndicatorEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;

        return this;
    }

    public MutableDirectBuffer buffer()
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

    public MatchEventIndicatorEncoder clear()
    {
        buffer.putByte(offset, (byte)(short)0);
        return this;
    }
    /**
     * 1=Last trade message for the event, 0=Not last
     *
     * @param value true if LastTradeMsg is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder lastTradeMsg(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 0) : bits & ~(1 << 0));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte lastTradeMsg(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 0) : bits & ~(1 << 0));
    }
    /**
     * 1=Last electronic volume message, 0=Not last
     *
     * @param value true if LastVolumeMsg is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder lastVolumeMsg(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 1) : bits & ~(1 << 1));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte lastVolumeMsg(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 1) : bits & ~(1 << 1));
    }
    /**
     * 1=Last real quote message, 0=Not last
     *
     * @param value true if LastQuoteMsg is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder lastQuoteMsg(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 2) : bits & ~(1 << 2));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte lastQuoteMsg(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 2) : bits & ~(1 << 2));
    }
    /**
     * 1=Last statistics message, 0=Not last
     *
     * @param value true if LastStatsMsg is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder lastStatsMsg(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 3) : bits & ~(1 << 3));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte lastStatsMsg(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 3) : bits & ~(1 << 3));
    }
    /**
     * 1=Last implied quote message, 0=Not last
     *
     * @param value true if LastImpliedMsg is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder lastImpliedMsg(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 4) : bits & ~(1 << 4));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte lastImpliedMsg(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 4) : bits & ~(1 << 4));
    }
    /**
     * 1=Message is sent during  recovery process
     *
     * @param value true if RecoveryMsg is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder recoveryMsg(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 5) : bits & ~(1 << 5));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte recoveryMsg(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 5) : bits & ~(1 << 5));
    }
    /**
     * 0=Reserved for future use
     *
     * @param value true if Reserved is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder reserved(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 6) : bits & ~(1 << 6));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte reserved(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 6) : bits & ~(1 << 6));
    }
    /**
     * 1=Last message for the event, 0=Not last
     *
     * @param value true if EndOfEvent is set or false if not.
     * @return this for a fluent API.
     */

    public MatchEventIndicatorEncoder endOfEvent(final boolean value)
    {
        byte bits = buffer.getByte(offset);
        bits = (byte)(value ? bits | (1 << 7) : bits & ~(1 << 7));
        buffer.putByte(offset, bits);
        return this;
    }

    public static byte endOfEvent(final byte bits, final boolean value)
    {
        return (byte)(value ? bits | (1 << 7) : bits & ~(1 << 7));
    }
}
