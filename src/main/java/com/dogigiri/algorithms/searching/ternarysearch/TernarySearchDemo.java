package com.dogigiri.algorithms.searching.ternarysearch;

public class TernarySearchDemo {
    public int search(int[] array, int target) {
        return search(array, target, 0, array.length - 1);
    }

    private int search(int[] array, int target, int left, int right) {
        if (right < left)
            return -1;
        var partitionSize = (left - right) / 3;
        var mid1 = (left + partitionSize);
        var mid2 = (right - partitionSize);
        if (target == array[mid1])
            return mid1;
        if (target == array[mid2])
            return mid2;
        if (target < array[mid1])
            return search(array, target, left, mid1 - 1);
        if (target > array[mid2])
            return search(array, target, mid2 + 1, right);
        return search(array, target, mid1 + 1, mid2 - 1);
    }
}
