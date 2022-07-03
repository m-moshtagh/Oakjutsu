package com.dogigiri.core.concurrency.tatiana.forkjoinpool.commonspool;

import java.util.concurrent.TimeUnit;

public class AppleTree {
    private String treeLabel;
    private int numberOfApples;

    public AppleTree(String treeLabel) {
        this.treeLabel = treeLabel;
        this.numberOfApples = 3;
    }

    public static AppleTree[] createTreeGarden(int size) {
        AppleTree[] appleTrees = new AppleTree[size];
        for (var i = 0; i < size; i++) {
            appleTrees[i] = new AppleTree("🌳#" + i);
        }
        return appleTrees;
    }

    public int pickApple(String workerName) {
        try {
            System.out.printf("%s started picking apples from %s \n", workerName, treeLabel);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfApples;
    }
}
