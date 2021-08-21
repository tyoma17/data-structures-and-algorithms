package com.tyoma17.util;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.stream.Collectors;

@Log4j2
public class Helper {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(arrayAsString(generateArray(20, 1000, 9999), 0, 20));
        }
    }

    public static int[] generateArray(int arrayLength, int minValue, int maxValue) {

        if (arrayLength < 1) {
            throw new IllegalArgumentException("'arrayLength' must be > 0");
        }

        int[] array = new int[arrayLength];

        for (int index = 0; index < arrayLength; index++) {
            array[index] = (int) (Math.random() * ((maxValue - minValue) + 1)) + minValue;
        }

        return array;
    }

    public static String arrayAsString(int[] array, int start, int end) {
        return Arrays.stream(array)
                .skip(start)
                .limit(end - start)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public static int getDigit(int position, int value, int radix) {
        int digit = value / (int) Math.pow(radix, position) % radix;
        log.debug("Value {} at position {} has the digit {}", value, position, digit);
        return digit;
    }
}
