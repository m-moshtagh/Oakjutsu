package com.dogigiri.algorithms.sorting.insertionsort;

public class InsertionSort {
    public void sort(int[] array) {
        for (var unsortedPart = 1; unsortedPart < array.length; unsortedPart++) {
            var current = array[unsortedPart];
            var sortedPart = unsortedPart - 1;
            while (sortedPart >= 0 && array[sortedPart] > current) {
                array[sortedPart + 1] = array[sortedPart];
                sortedPart--;
            }
            array[sortedPart + 1] = current;
        }
    }
}
