package com.dogigiri.algorithms.sorting;

public class SelectionSort {
    public static void sort(int[] array){
        for (int unsortedList = array.length - 1; unsortedList >0; unsortedList--) {
            int largestElement = 0;
            for (int i = 1; i <= unsortedList; i++) {
                if (array[i] > array[largestElement]) {
                    largestElement = i;
                }
            }
            swap(array, largestElement, unsortedList);
        }
    }

    private static void swap(int[] array, int largestElement, int unsortedList) {
        int temp = array[largestElement];
        array[largestElement] = array[unsortedList];
        array[unsortedList] = temp;
    }

    public static void printArray(int[] array) {
        for(int a: array) System.out.println(a);
    }
    public static void main(String[] args) {
        int[] arr = {65,484,5,21};
        sort(arr);
        printArray(arr);
    }
}
