package com.tyoma17.algorithms.search;

import com.tyoma17.util.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/search/unsorted_arrays.csv", numLinesToSkip = 1, delimiter = ';')
    void search(String arrayAsString, int value, int expectedIndex) {
        int[] array = TestHelper.convertArrayAsStringToIntArray(arrayAsString);
        assertEquals(expectedIndex, BinarySearch.search(array, value));
    }
}