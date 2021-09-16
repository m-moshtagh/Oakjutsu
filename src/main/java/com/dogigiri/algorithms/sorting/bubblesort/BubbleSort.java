package com.dogigiri.algorithms.sorting.bubblesort;

public class BubbleSort {
    public void sort(int[] array) {
        boolean isSorted;
        for (var i = array.length - 1; i > 0; i--) {
            isSorted = true;
            for (var j = 0; j < i; j++) {
                if(array[j] > array[j + 1]){
                    swapItem(array, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private static void swapItem(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
