package com.dogigiri.algorithms.sorting.mergesort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MergeSortTest {
    MergeSort mSort;
    int[] array;

    @BeforeEach
    void setUp() {
        mSort = new MergeSort();
        array = new int[]{4, 2, 7, 9, 3};
    }

    @Test
    void sort() {
        mSort.sort(array);
        Assertions.assertEquals("[2, 3, 4, 7, 9]", Arrays.toString(array));
    }
}