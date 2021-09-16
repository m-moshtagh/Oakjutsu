package com.dogigiri.algorithms.sorting.mergesort;

public class MergeSort {
    private static void merge(int[] leftArray, int[] rightArray, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) result[k++] = leftArray[i++];
            else result[k++] = rightArray[j++];
        }
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }
    }

    private static void copyToArray(int[] source, int sourceStartPoint, int[] target, int length) {
        System.arraycopy(source, sourceStartPoint, target, 0, length);
    }

    public void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        var middle = array.length / 2;
        var leftArray = new int[middle];
        copyToArray(array, 0, leftArray, middle);
        var rightArray = new int[array.length - middle];
        if (array.length - middle >= 0) copyToArray(array, middle, rightArray, array.length - middle);

        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, array);
    }
}
