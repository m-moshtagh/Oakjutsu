package com.dogigiri.algorithms.searching.binarysearch;

import java.util.Arrays;

public class BinarySearchIterationDemo {
    public int binSearch(int[] array, int target) {
        Arrays.sort(array);
        var left = 0;
        var right = array.length - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            if(middle == array[target])
                return middle;
            if(array[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}
