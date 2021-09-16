package com.dogigiri.algorithms.sorting.quicksort;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class QuickSort {
    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (var i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, ++boundary);
            }
        }
        return boundary;
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
}
