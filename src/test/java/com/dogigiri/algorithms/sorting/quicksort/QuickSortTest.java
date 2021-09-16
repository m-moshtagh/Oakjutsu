package com.dogigiri.algorithms.sorting.quicksort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    int[] array;
    QuickSort qSort;
    @BeforeEach
    void setUp() {
        qSort = new QuickSort();
        array = new int[]{4,2,6,1,9};
    }

    @Test
    void sort() {
        qSort.sort(array);
        assertEquals("[1, 2, 4, 6, 9]", Arrays.toString(array));
    }
}