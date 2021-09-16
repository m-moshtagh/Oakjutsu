package com.dogigiri.algorithms.sorting.countingsort;

public class CountingSort {
    public void sort(int[] array, int max) {
        int[] countingArray = new int[max + 1];
        var k = 0;
        for (var item : array) {
            countingArray[item]++;
        }
        for (var i = 0; i < countingArray.length; i++) {
            for (var j = 0; j < countingArray[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
