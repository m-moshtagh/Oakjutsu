package com.dogigiri.core.concurrency.tatiana.forkjoinpool.commonspool;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

public class PickFruitsWithInvokeAll {
    public static void main(String[] args) {
        AppleTree[] treeGarden = AppleTree.createTreeGarden(4);

        Callable<Void> hamid = createApplePicker(treeGarden, 0, 1, "Hamid");
        Callable<Void> ali = createApplePicker(treeGarden, 1, 3, "Ali");
        Callable<Void> javad = createApplePicker(treeGarden, 3, 4, "Javad");

        ForkJoinPool.commonPool().invokeAll(Arrays.asList(hamid, ali, javad));
    }

    public static Callable<Void> createApplePicker(AppleTree[] appleTrees, int fromIndex, int toIndex, String workerName) {
        return () -> {
            for (var i = fromIndex; i < toIndex; i++) {
                appleTrees[i].pickApple(workerName);
            }
            return null;
        };
    }
}
