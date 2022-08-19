/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

@SuppressWarnings("all")
public enum OpenCloseSettlFlag
{

    /**
     * Daily Open Price
     */
    DailyOpenPrice((short)0),


    /**
     * Indicative Opening Price
     */
    IndicativeOpeningPrice((short)5),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((short)255);

    private final short value;

    OpenCloseSettlFlag(final short value)
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
    public static OpenCloseSettlFlag get(final short value)
    {
        switch (value)
        {
            case 0: return DailyOpenPrice;
            case 5: return IndicativeOpeningPrice;
            case 255: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
