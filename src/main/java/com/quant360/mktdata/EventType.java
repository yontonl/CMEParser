/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.mktdata;

@SuppressWarnings("all")
public enum EventType
{

    /**
     * Activation
     */
    Activation((short)5),


    /**
     * Last Eligible Trade Date
     */
    LastEligibleTradeDate((short)7),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((short)255);

    private final short value;

    EventType(final short value)
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
    public static EventType get(final short value)
    {
        switch (value)
        {
            case 5: return Activation;
            case 7: return LastEligibleTradeDate;
            case 255: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
