package com.dogigiri.core.concurrency.executiveframework.callable;

public class Twitter {
    public static int simulate() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
