package io.github.erikcaffrey.ayudamexico.util;

public class StringUtils {

    public static final String EMPTY = "";

    public static boolean isNullOrEmpty(final String string) {
        return string == null || string.isEmpty();
    }
}