/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

@SuppressWarnings("all")
public enum MDEntryTypeDailyStatistics
{

    /**
     * Settlement Price
     */
    SettlementPrice((byte)54),


    /**
     * Cleared Volume
     */
    ClearedVolume((byte)66),


    /**
     * Open Interest
     */
    OpenInterest((byte)67),


    /**
     * Fixing Price
     */
    FixingPrice((byte)87),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((byte)0);

    private final byte value;

    MDEntryTypeDailyStatistics(final byte value)
    {
        this.value = value;
    }

    /**
     * The raw encoded value in the Java type representation.
     *
     * @return the raw value encoded.
     */
    public byte value()
    {
        return value;
    }

    /**
     * Lookup the enum value representing the value.
     *
     * @param value encoded to be looked up.
     * @return the enum value representing the value.
     */
    public static MDEntryTypeDailyStatistics get(final byte value)
    {
        switch (value)
        {
            case 54: return SettlementPrice;
            case 66: return ClearedVolume;
            case 67: return OpenInterest;
            case 87: return FixingPrice;
            case 0: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
