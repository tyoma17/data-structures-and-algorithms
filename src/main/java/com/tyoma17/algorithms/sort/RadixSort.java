package com.tyoma17.algorithms.sort;

import com.tyoma17.util.Helper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RadixSort {

    public static int[] sort(int[] unsortedArray, int radix, int width) {

        for (int i = 0; i < width; i++) {
            radixSingleSort(unsortedArray, i, radix);
        }

        return unsortedArray;
    }

    private static void radixSingleSort(int[] array, int position, int radix) {

        log.debug("Start of sorting of array: {}", Helper.arrayAsString(array, 0, array.length));
        log.debug("Sorting by position = {}", position);
        int numItems = array.length;
        int[] countArray = new int[radix];

        for (int value : array) {
            countArray[Helper.getDigit(position, value, radix)]++;
        }

        log.debug("Count array: {}", Helper.arrayAsString(countArray, 0, countArray.length));

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        log.debug("Adjusted count array: {}", Helper.arrayAsString(countArray, 0, countArray.length));

        int[] tempArray = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            int countArrayIndex = Helper.getDigit(position, array[tempIndex], radix);
            tempArray[--countArray[countArrayIndex]] = array[tempIndex];
            log.debug("Count array: {}", Helper.arrayAsString(countArray, 0, countArray.length));
            log.debug("tempArray[{}]: {}", countArray[countArrayIndex], array[tempIndex]);
            log.debug("tempArray: {}", Helper.arrayAsString(tempArray, 0, tempArray.length));
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            array[tempIndex] = tempArray[tempIndex];
        }

        log.debug("Sorted array: {}", Helper.arrayAsString(array, 0, array.length));
        log.debug("End of sorting by position = {}", position);
    }
}
