package com.tyoma17.algorithms.sort;

public class ShellSort {

    public static int[] sort(int[] unsortedArray) {

        final int length = unsortedArray.length;

        for (int gap = length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < length; i++) {

                int currentElement = unsortedArray[i];
                int j = i;

                while (j >= gap && unsortedArray[j - gap] > currentElement) {
                    unsortedArray[j] = unsortedArray[j - gap];
                    j -= gap;
                }

                unsortedArray[j] = currentElement;
            }
        }

        return unsortedArray;
    }
}
