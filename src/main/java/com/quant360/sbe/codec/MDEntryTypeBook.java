/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

@SuppressWarnings("all")
public enum MDEntryTypeBook
{

    /**
     * Bid
     */
    Bid((byte)48),


    /**
     * Offer
     */
    Offer((byte)49),


    /**
     * Implied Bid
     */
    ImpliedBid((byte)69),


    /**
     * Implied Offer
     */
    ImpliedOffer((byte)70),


    /**
     * Book Reset
     */
    BookReset((byte)74),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((byte)0);

    private final byte value;

    MDEntryTypeBook(final byte value)
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
    public static MDEntryTypeBook get(final byte value)
    {
        switch (value)
        {
            case 48: return Bid;
            case 49: return Offer;
            case 69: return ImpliedBid;
            case 70: return ImpliedOffer;
            case 74: return BookReset;
            case 0: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
