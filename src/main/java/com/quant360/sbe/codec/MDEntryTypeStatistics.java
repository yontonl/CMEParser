/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

@SuppressWarnings("all")
public enum MDEntryTypeStatistics
{

    /**
     * Open Price
     */
    OpenPrice((byte)52),


    /**
     * High Trade
     */
    HighTrade((byte)55),


    /**
     * Low Trade
     */
    LowTrade((byte)56),


    /**
     * Highest Bid
     */
    HighestBid((byte)78),


    /**
     * Lowest Offer
     */
    LowestOffer((byte)79),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((byte)0);

    private final byte value;

    MDEntryTypeStatistics(final byte value)
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
    public static MDEntryTypeStatistics get(final byte value)
    {
        switch (value)
        {
            case 52: return OpenPrice;
            case 55: return HighTrade;
            case 56: return LowTrade;
            case 78: return HighestBid;
            case 79: return LowestOffer;
            case 0: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
