package com.bweebaa.util;

public class StringUtil {
    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
    public static boolean IsNullOrWhiteSpace(final CharSequence cs) {
        final int strLen = length(cs);
        if(strLen == 0){
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
