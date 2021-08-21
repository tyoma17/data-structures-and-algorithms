package com.tyoma17.algorithms.search;

public class LinearSearch {

    public static int search(int[] array, int value) {

        final int length = array.length;

        for (int i = 0; i < length; i++) {

            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

}
