package com.dogigiri.algorithms.sorting.bucketsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        sortMergeBuckets(createBuckets(array, numberOfBuckets), array);
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());
        for (var item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }

    private void sortMergeBuckets(List<List<Integer>> buckets, int[] array) {
        var i = 0;
        for (var bucket : buckets) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }
}
