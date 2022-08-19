/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

@SuppressWarnings("all")
public enum OrderUpdateAction
{

    /**
     * New
     */
    New((short)0),


    /**
     * Update
     */
    Update((short)1),


    /**
     * Delete
     */
    Delete((short)2),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((short)255);

    private final short value;

    OrderUpdateAction(final short value)
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
    public static OrderUpdateAction get(final short value)
    {
        switch (value)
        {
            case 0: return New;
            case 1: return Update;
            case 2: return Delete;
            case 255: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
