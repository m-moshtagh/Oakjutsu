package com.dogigiri.algorithms.searching.binarysearch;

import java.util.Arrays;

public class BinarySearchRecursionDemo {
    public static int binSearch(int[] array, int target) {
        Arrays.sort(array);
        return binSearch(array, target, 0, array.length - 1);
    }

    public static int binSearch(int[] array, int target, int left, int right) {
        if (right < left)
            return -1;
        var middle = (left + right) / 2;
        if (array[middle] == target)
            return middle;
        if (array[middle] > target)
            return binSearch(array, target, left, middle - 1);

        return binSearch(array, target, middle + 1, right);
    }
}
