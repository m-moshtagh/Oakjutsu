package com.dogigiri.algorithms.sorting.bubblesort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BubbleSortTest {
    int[] array;
    BubbleSort bSort = new BubbleSort();

    @BeforeEach
    void setUp() {
        array = new int[]{6, 8, 2, 4, 9};
    }

    @Test
    void sort() {
        bSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}