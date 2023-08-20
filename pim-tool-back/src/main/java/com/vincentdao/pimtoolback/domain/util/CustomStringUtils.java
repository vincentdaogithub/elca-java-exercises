package com.vincentdao.pimtoolback.domain.util;

public final class CustomStringUtils {

    public static boolean hasTrailingSpaces(String stringToCheck) throws NullPointerException {
        return stringToCheck.trim().length() != stringToCheck.length();
    }

    private CustomStringUtils() { }
}
