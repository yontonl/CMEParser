/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.mktdata;

@SuppressWarnings("all")
public enum LegSide
{

    /**
     * Buy Side
     */
    BuySide((short)1),


    /**
     * Sell Side
     */
    SellSide((short)2),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((short)255);

    private final short value;

    LegSide(final short value)
    {
        this.value = value;
    }

    /**
     * The raw encoded value in the Java type representation.
     *
     * @return the raw value encoded.
     */
    public short value()
    {
        return value;
    }

    /**
     * Lookup the enum value representing the value.
     *
     * @param value encoded to be looked up.
     * @return the enum value representing the value.
     */
    public static LegSide get(final short value)
    {
        switch (value)
        {
            case 1: return BuySide;
            case 2: return SellSide;
            case 255: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
