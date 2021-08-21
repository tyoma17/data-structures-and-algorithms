package com.tyoma17.algorithms.sort;

public class SelectionSort {

    public static int[] sort(int[] unsortedArray) {

        final int length = unsortedArray.length;

        for (int lastUnsortedIndex = length - 1;
             lastUnsortedIndex > 0;
             lastUnsortedIndex--) {

            int largestIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {

                if (unsortedArray[i] > unsortedArray[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap(unsortedArray, largestIndex, lastUnsortedIndex);
        }

        return unsortedArray;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
