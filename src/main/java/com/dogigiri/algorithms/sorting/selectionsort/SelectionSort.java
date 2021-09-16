package com.dogigiri.algorithms.sorting.selectionsort;

public class SelectionSort {
    private static void swap(int[] array, int largestElement, int unsortedList) {
        int temp = array[largestElement];
        array[largestElement] = array[unsortedList];
        array[unsortedList] = temp;
    }

    public void sort(int[] array) {
        for (int unsortedList = array.length - 1; unsortedList > 0; unsortedList--) {
            int largestElement = 0;
            for (int i = 1; i <= unsortedList; i++) {
                if (array[i] > array[largestElement]) {
                    largestElement = i;
                }
            }
            swap(array, largestElement, unsortedList);
        }
    }

}
