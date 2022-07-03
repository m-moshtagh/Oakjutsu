package com.dogigiri.core.concurrency.mosh.executiveframework.creatingpool;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(3);
        try {
            for (var i = 0; i < 10; i++) {
                executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
            }
        }
        finally {
            executorService.shutdown();
        }
    }
}
