package com.dogigiri.algorithms.sorting.insertionsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
    InsertionSort iSort;
    int[] arr;
    @BeforeEach
    void setUp() {
        iSort = new InsertionSort();
        arr = new int[]{5,2,9,10,7,1};
    }

    @Test
    void sort() {
        iSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}