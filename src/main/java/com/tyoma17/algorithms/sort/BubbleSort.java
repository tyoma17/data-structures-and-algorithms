package com.tyoma17.algorithms.sort;

public class BubbleSort {

    public static int[] sort(int[] unsortedArray) {

        final int length = unsortedArray.length;

        for (int lastUnsortedIndex = length - 1;
             lastUnsortedIndex > 0;
             lastUnsortedIndex--) {

            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    swap(unsortedArray, i, i + 1);
                }
            }
        }

        return unsortedArray;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
