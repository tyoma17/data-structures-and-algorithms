package com.tyoma17.algorithms.search;

import com.tyoma17.util.Helper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BinarySearch { // works only for sorted arrays

    public static int search(int[] array, int value) {
        return search(array, 0, array.length, value);
    }

    private static int search(int[] array, int startIndex, int endIndex, int value) {

        log.debug("Searching in the array: {}...", Helper.arrayAsString(array, startIndex, endIndex));

        if (startIndex >= endIndex) {
            return -1;
        }

        int middle = (startIndex + endIndex) / 2;
        log.debug("Middle = {}", middle);

        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return search(array, middle + 1, endIndex, value);
        } else {
            return search(array, startIndex, middle, value);
        }
    }
}
