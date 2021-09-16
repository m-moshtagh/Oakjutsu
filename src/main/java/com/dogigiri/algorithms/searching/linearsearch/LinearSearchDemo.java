package com.dogigiri.algorithms.searching.linearsearch;

public class LinearSearchDemo {
    public int search(int[] array, int target) {
        for (var i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }
}
