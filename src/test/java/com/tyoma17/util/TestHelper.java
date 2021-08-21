package com.tyoma17.util;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class TestHelper {

    public static int[] convertArrayAsStringToIntArray(String arrayAsString) {

        String[] parts = arrayAsString.split(",");
        final int length = parts.length;
        int[] intArray = new int[length];

        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(parts[i]);
        }

        return intArray;
    }

    public static String convertIntArrayToArrayAsString(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(joining(","));
    }
}
