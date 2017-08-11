package com.github.unit_testing.demo.alarm.temperature;

import java.math.BigDecimal;

public class Util {
    public static double round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
