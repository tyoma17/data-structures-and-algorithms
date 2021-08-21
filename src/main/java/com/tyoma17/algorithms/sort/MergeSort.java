package com.tyoma17.algorithms.sort;

import com.tyoma17.util.Helper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MergeSort {

    public static int[] sort(int[] unsortedArray, int start, int end) {

        if (end - start < 2) {
            return unsortedArray;
        }

        log.debug("Splitting [{}]...", Helper.arrayAsString(unsortedArray, start, end));

        int mid = (start + end) / 2;
        sort(unsortedArray, start, mid);
        sort(unsortedArray, mid, end);
        merge(unsortedArray, start, mid, end);

        return unsortedArray;
    }

    private static void merge(int[] unsortedArray, int start, int mid, int end) {

        String leftHalf = Helper.arrayAsString(unsortedArray, start, mid);
        String rightHalf = Helper.arrayAsString(unsortedArray, mid, end);

        if (unsortedArray[mid - 1] <= unsortedArray[mid]) {
            return;
        }

        int i = start; // i = 2
        int j = mid; // j = 3
        int tempIndex = 0; // 3

        int[] tempArray = new int[end - start];

        while (i < mid && j < end) {
            tempArray[tempIndex++] = unsortedArray[i] <= unsortedArray[j] ? unsortedArray[i++] : unsortedArray[j++];
        }

        System.arraycopy(unsortedArray, i, unsortedArray, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, unsortedArray, start, tempIndex);
        String sortedPart = Helper.arrayAsString(unsortedArray, start, end);
        log.debug("Merging [{}] with [{}] ---> [{}]", leftHalf, rightHalf, sortedPart);
    }
}
