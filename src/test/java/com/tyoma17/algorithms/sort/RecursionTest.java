package com.tyoma17.algorithms.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sort/factorial.csv", numLinesToSkip = 1, delimiter = ';')
    void factorial(int number, int factorial) {
        assertEquals(factorial, Recursion.factorial(number));
    }
}