package com.tyoma17.algorithms.sort;

public class InsertionSort {

    public static int[] sort(int[] unsortedArray) {

        final int length = unsortedArray.length;

        for (int firstUnsortedIndex = 1;
             firstUnsortedIndex < length;
             firstUnsortedIndex++) {

            int currentElement = unsortedArray[firstUnsortedIndex];
            int i;

            for (i = firstUnsortedIndex;
                 i > 0 && unsortedArray[i - 1] > currentElement;
                 i--) {

                unsortedArray[i] = unsortedArray[i - 1];
            }

            unsortedArray[i] = currentElement;
        }

        return unsortedArray;
    }
}
