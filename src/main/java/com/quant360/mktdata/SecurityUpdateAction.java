/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.mktdata;

@SuppressWarnings("all")
public enum SecurityUpdateAction
{

    /**
     * Add
     */
    Add((byte)65),


    /**
     * Delete
     */
    Delete((byte)68),


    /**
     * Modify
     */
    Modify((byte)77),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((byte)0);

    private final byte value;

    SecurityUpdateAction(final byte value)
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
    public static SecurityUpdateAction get(final byte value)
    {
        switch (value)
        {
            case 65: return Add;
            case 68: return Delete;
            case 77: return Modify;
            case 0: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
