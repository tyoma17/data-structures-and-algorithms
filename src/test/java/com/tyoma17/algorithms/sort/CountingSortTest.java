package com.tyoma17.algorithms.sort;

import com.tyoma17.util.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CountingSortTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sort/arrays.csv", numLinesToSkip = 1, delimiter = ';')
    void sort(String unsortedArrayAsString, String sortedArrayAsString) {

        int[] unsortedArray = TestHelper.convertArrayAsStringToIntArray(unsortedArrayAsString);
        int[] actualSortedArray = CountingSort.sort(unsortedArray, 0, 100);
        int[] expectedSortedArray = TestHelper.convertArrayAsStringToIntArray(sortedArrayAsString);

        assertTrue(Arrays.equals(expectedSortedArray, actualSortedArray));
    }
}