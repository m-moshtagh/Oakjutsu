package com.dogigiri.algorithms.searching.jumpsearch;

public class JumpSearchDemo {
    public int search(int[] array, int target) {
        var blockSize = (int) Math.sqrt(array.length);
        var start = 0;
        var next = blockSize;
        while (next < array.length && array[next - 1] < target) {
            start = next;
            next += blockSize;
            if(next > array.length)
                next = array.length;
        }
        for(var i = start; i < next; i++)
            if(array[i] == target)
                return i;

        return -1;
    }
}
