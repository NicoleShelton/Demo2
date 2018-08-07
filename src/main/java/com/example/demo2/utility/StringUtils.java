package com.example.demo2.utility;

public class StringUtils {
    public static Long getLong(String s) {
        try {
            return s != null ? Long.valueOf(s) : null;
        } catch (Exception e) {
            return null;
        }
    }
}
