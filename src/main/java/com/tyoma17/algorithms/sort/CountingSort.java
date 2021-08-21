package com.tyoma17.algorithms.sort;

import com.tyoma17.util.Helper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CountingSort {

    public static int[] sort(int[] unsortedArray, int minValue, int maxValue) {

        int[] countArray = new int[(maxValue - minValue) + 1];

        for (int i = 0; i < unsortedArray.length; i++) {
            countArray[unsortedArray[i] - minValue]++;
        }

        log.debug("Count array: {}", Helper.arrayAsString(countArray, 0, countArray.length));

        int j = 0;

        for (int i = minValue; i <= maxValue; i++) {
            while (countArray[i - minValue] > 0) {
                unsortedArray[j++] = i;
                countArray[i - minValue]--;
            }
        }

        return unsortedArray;
    }
}
