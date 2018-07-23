package com.jd.excalibur.common;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class NumberUtils {

    public static boolean isNullOrZero(Long number) {
        return number == null || number.longValue() == 0L;
    }

    public static boolean isNullOrZero(Integer number) {
        return number == null || number.intValue() == 0;
    }

    public static boolean isNullOrZero(Double number) {
        return number == null || number.doubleValue() == 0.0;
    }

    public static boolean isNullOrZero(BigDecimal v) {
        return v == null || v.doubleValue() == 0;
    }

    public static Long parse2Long(String str) {
        return parse2Long(str, 0L);
    }

    public static Long parse2Long(String str, Long defaultValue) {
        if (!org.apache.commons.lang.math.NumberUtils.isDigits(str)) {
            return defaultValue;
        }
        return Long.parseLong(str);
    }

    public static Integer parse2Integer(String str) {
        return parse2Integer(str, 0);
    }

    public static Integer parse2Integer(String str, Integer defaultValue) {
        if (!org.apache.commons.lang.math.NumberUtils.isDigits(str)) {
            return defaultValue;
        }
        return Integer.parseInt(str);
    }
}
