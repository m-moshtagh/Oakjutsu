package com.dogigiri.core.concurrency.mosh.executiveframework.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(3);
        try {
            var future = executorService.submit(Twitter::simulate);
            try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } finally {
            executorService.shutdown();
        }
    }
}
