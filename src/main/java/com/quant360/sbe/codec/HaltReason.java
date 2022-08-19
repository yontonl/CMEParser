/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

@SuppressWarnings("all")
public enum HaltReason
{

    /**
     * Group Schedule
     */
    GroupSchedule((short)0),


    /**
     * Surveillance Intervention 
     */
    SurveillanceIntervention((short)1),


    /**
     * Market Event 
     */
    MarketEvent((short)2),


    /**
     * Instrument Activation
     */
    InstrumentActivation((short)3),


    /**
     * Instrument Expiration
     */
    InstrumentExpiration((short)4),


    /**
     * Unknown
     */
    Unknown((short)5),


    /**
     * Recovery In Process
     */
    RecoveryInProcess((short)6),

    /**
     * To be used to represent not present or null.
     */
    NULL_VAL((short)255);

    private final short value;

    HaltReason(final short value)
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
    public static HaltReason get(final short value)
    {
        switch (value)
        {
            case 0: return GroupSchedule;
            case 1: return SurveillanceIntervention;
            case 2: return MarketEvent;
            case 3: return InstrumentActivation;
            case 4: return InstrumentExpiration;
            case 5: return Unknown;
            case 6: return RecoveryInProcess;
            case 255: return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
