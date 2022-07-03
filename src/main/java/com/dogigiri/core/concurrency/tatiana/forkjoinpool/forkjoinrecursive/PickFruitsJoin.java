package com.dogigiri.core.concurrency.tatiana.forkjoinpool.forkjoinrecursive;

import com.dogigiri.core.concurrency.tatiana.forkjoinpool.commonspool.AppleTree;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class PickFruitsJoin {
    public static void main(String[] args) {
        AppleTree[] treeGarden = AppleTree.createTreeGarden(6);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        PickFruitTask task = new PickFruitTask(treeGarden, 0, treeGarden.length);

        pool.invoke(task);
    }

    public static class PickFruitTask extends RecursiveTask<Integer> {
        private final AppleTree[] appleTrees;
        private final int startIndex;
        private final int endIndex;

        private final int taskThreshold = 4;

        public PickFruitTask(AppleTree[] appleTrees, int startIndex, int endIndex) {
            this.appleTrees = appleTrees;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        protected Integer doCompute() {
            return IntStream.range(startIndex, endIndex).map(i -> appleTrees[i].pickApple("babak")).sum();
        }

        @Override
        protected Integer compute() {
            if (endIndex - startIndex < taskThreshold)
                return doCompute();
            int midPoint = startIndex + (endIndex - startIndex) / 2;
            PickFruitTask leftSum = new PickFruitTask(appleTrees, startIndex, midPoint);
            PickFruitTask rightSum = new PickFruitTask(appleTrees, midPoint + 1, endIndex);

            rightSum.fork();
            return leftSum.compute() + rightSum.join();
        }
    }
}
