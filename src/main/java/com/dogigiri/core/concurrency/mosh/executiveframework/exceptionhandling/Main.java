package com.dogigiri.core.concurrency.mosh.executiveframework.exceptionhandling;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("completed a task");
            throw new IllegalStateException();
        });
        try {
            var exceptionFuture = future.exceptionally(e -> -1).get();
            System.out.println(exceptionFuture);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
