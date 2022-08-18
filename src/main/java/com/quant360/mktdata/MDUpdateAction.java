/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.mktdata;

@SuppressWarnings("all")
public enum MDUpdateAction
{

    /**
     * New
     */
    New((short)0),


    /**
     * Change
     */
    Change((short)1),


    /**
     * Delete
     */
    Delete((short)2),


    /**
     * Delete Thru
     */
    DeleteThru((short)3),


    /**
     * Delete From
     */
    DeleteFrom((short)4),


    /**
     * Overlay
     */
    Overlay((short)5),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((short)255);

    private final short value;

    MDUpdateAction(final short value)
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
    public static MDUpdateAction get(final short value)
    {
        switch (value)
        {
            case 0: return New;
            case 1: return Change;
            case 2: return Delete;
            case 3: return DeleteThru;
            case 4: return DeleteFrom;
            case 5: return Overlay;
            case 255: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
