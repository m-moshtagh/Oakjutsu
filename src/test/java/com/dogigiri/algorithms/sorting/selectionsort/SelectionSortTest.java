package com.dogigiri.algorithms.sorting.selectionsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SelectionSortTest {
    int[] array;
    SelectionSort sSort;

    @BeforeEach
    void setUp() {
        array = new int[]{9, 4, 7, 11};
        sSort = new SelectionSort();
    }

    @Test
    void sort() {
        sSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}