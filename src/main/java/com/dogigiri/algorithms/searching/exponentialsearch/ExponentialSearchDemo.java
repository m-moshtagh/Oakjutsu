package com.dogigiri.algorithms.searching.exponentialsearch;

import com.dogigiri.algorithms.searching.binarysearch.BinarySearchRecursionDemo;

public class ExponentialSearchDemo {
    public int search(int[] array, int target) {
        var bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        var left = bound / 2;
        var right = Math.min(bound, array.length - 1);

        return BinarySearchRecursionDemo.binSearch(array, target, left, right);
    }
}
