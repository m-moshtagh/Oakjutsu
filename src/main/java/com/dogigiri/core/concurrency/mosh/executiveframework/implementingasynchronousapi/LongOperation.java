package com.dogigiri.core.concurrency.mosh.executiveframework.implementingasynchronousapi;

public class LongOperation {
    public static void takeTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void takeTime(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
