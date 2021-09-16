package com.dogigiri.algorithms.sorting.bucketsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {
    BucketSort bSort;
    int[] array;
    @BeforeEach
    void setUp() {
        bSort = new BucketSort();
        array = new int[]{6,4,2,8,6,7,1,2,5};
    }

    @Test
    void sort() {
        bSort.sort(array,4);
        System.out.println(Arrays.toString(array));
    }
}