package com.dogigiri.algorithms.sorting.countingsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {
    CountingSort cSort;
    int[] array;
    @BeforeEach
    void setUp() {
        cSort = new CountingSort();
        array = new int[]{2,7,1,2,5,9,7,6};
    }

    @Test
    void sort() {
        cSort.sort(array, Arrays.stream(array).max().orElse(1));
        System.out.println(Arrays.toString(array));
    }
}