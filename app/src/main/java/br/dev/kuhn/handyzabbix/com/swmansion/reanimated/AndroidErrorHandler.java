package com.swmansion.reanimated;

public class AndroidErrorHandler {
    public static void raise(String str) {
        throw new RuntimeException(str);
    }
}
