package com.tyoma17.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static int[] sort(int[] unsortedArray, int radix) {

        final int length = unsortedArray.length;
        List<Integer>[] buckets = new List[radix];

        for (int i = 0; i < radix; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            buckets[hash(unsortedArray[i], 10)].add(unsortedArray[i]);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;

        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                unsortedArray[j++] = value;
            }
        }

        return unsortedArray;
    }

    private static int hash(int value, int radix) {
        return value / 1000 % radix;
    }
}
