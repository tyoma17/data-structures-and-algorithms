package com.tyoma17.data_structures.binary_search_tree.heap;

import com.tyoma17.util.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sort/arrays.csv", numLinesToSkip = 1, delimiter = ';')
    void sort(String unsortedArrayAsString, String sortedArrayAsString) {

        int[] unsortedArray = TestHelper.convertArrayAsStringToIntArray(unsortedArrayAsString);
        Heap heap = new Heap(10);

        for (int intValue : unsortedArray) {
            heap.insert(intValue);
        }

        heap.sort();

        assertEquals("Heap: " + sortedArrayAsString, heap.heapAsString());
    }
}