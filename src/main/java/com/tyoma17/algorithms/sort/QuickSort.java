package com.tyoma17.algorithms.sort;

import com.tyoma17.util.Helper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class QuickSort {

    public static int[] sort(int[] unsortedArray, int start, int end) {

        if (end - start < 2) {
            return unsortedArray;
        }

        log.debug("Sorting {}", Helper.arrayAsString(unsortedArray, start, end));

        int pivotIndex = partition(unsortedArray, start, end);
        sort(unsortedArray, start, pivotIndex);
        sort(unsortedArray, pivotIndex + 1, end);

        return unsortedArray;
    }

    private static int partition(int[] array, int start, int end) {

        log.debug("-----------------------");
        log.debug("Start of partitioning");

        int pivot = array[start];
        log.debug("Pivot = {}", pivot);
        int i = start;
        log.debug("i = {}", i);
        int j = end;
        log.debug("j = {}", j);

        while (i < j) {

            while (i < j && array[--j] >= pivot) ; // empty loop body to keep decrementing j
            log.debug("j = {}", j);

            if (i < j) {
                array[i] = array[j];
                log.debug(Helper.arrayAsString(array, start, end));
            }

            while (i < j && array[++i] <= pivot) ; // empty loop body to keep incrementing i
            log.debug("i = {}", i);

            if (i < j) {
                array[j] = array[i];
                log.debug(Helper.arrayAsString(array, start, end));
            }
        }

        array[j] = pivot;
        log.debug(Helper.arrayAsString(array, start, end));
        log.debug("Index of pivot {} is {}", pivot, j);
        log.debug("Left part: {}", Helper.arrayAsString(array, start, j));
        log.debug("Right part: {}", Helper.arrayAsString(array, j + 1, end));
        log.debug("End of partitioning");
        log.debug("-----------------------");
        return j;
    }

}
