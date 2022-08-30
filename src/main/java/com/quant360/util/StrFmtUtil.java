package com.quant360.util;

import com.quant360.sbe.codec.PRICE9Decoder;
import com.quant360.sbe.codec.PRICENULL9Decoder;

import java.time.format.DateTimeFormatter;

public class StrFmtUtil {
    public static String nullPriceToString(PRICENULL9Decoder price) {
        if (price.mantissa() == PRICENULL9Decoder.mantissaNullValue()) {
            return "null";
        }
        return String.format("%.1f", price.mantissa() * Math.pow(10, price.exponent()));
    }

    public static String priceToString(PRICE9Decoder price) {
        return String.format("%.1f", price.mantissa() * Math.pow(10, price.exponent()));
    }

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
}
