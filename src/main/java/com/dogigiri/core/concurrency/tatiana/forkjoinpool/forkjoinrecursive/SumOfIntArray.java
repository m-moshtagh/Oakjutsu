package com.dogigiri.core.concurrency.tatiana.forkjoinpool.forkjoinrecursive;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumOfIntArray {
    public static void main(String[] args) {
        var intArray = new int[]{2,3,1};
        var pool = ForkJoinPool.commonPool();
        var arrayElementSum = new ArrayElementSum(intArray, intArray.length);
        Integer result = pool.invoke(arrayElementSum);
        System.out.println(result);
    }

    public static class ArrayElementSum extends RecursiveTask<Integer> {
        private final int[] array;
        private final int index;

        public ArrayElementSum(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        @Override
        protected Integer compute() {
            if (index <= 0)
                return 0;
            var rec = new ArrayElementSum(array, index - 1).fork();
            return array[index - 1] + rec.join();
        }
    }
}
