package com.dogigiri.core.concurrency.mosh.executiveframework.creatingcompletablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(3);
        var future2 = CompletableFuture.supplyAsync(() -> 2, executorService);
        try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
