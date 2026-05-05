package com.effortcure.util;

public class DurationConverterUtil {
    public static int convertToSecondes(String hours, String minutes) {
        int h = 0, m = 0;
        try {
            h = Integer.parseInt(hours);
            m = Integer.parseInt(minutes);
        } catch (NumberFormatException e) {
            return -1; 
        }
        return h * 3600 + m * 60;
    }
}
