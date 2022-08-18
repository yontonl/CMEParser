package com.quant360.util;

public class MathUtil {
    public static double scientificNotation(double mantissa, int exponent) {
        return mantissa * Math.pow(10, exponent);
    }
}
