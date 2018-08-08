package com.example.demo2.utility;

public class StringUtils {
    public static Long getLong(String s) {
        try {
            return s != null ? Long.valueOf(s) : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
