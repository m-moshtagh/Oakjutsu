package com.dogigiri.core.concurrency.mosh.executiveframework.waitingforalltaskstocomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

        var finalCompletableFuture = CompletableFuture.allOf(first, second, third);
        finalCompletableFuture.thenRun(() -> {
            try {
                // usually get() method blocks the current thread.
                var firstResult = first.get();
                var secondResult = second.get();
                var thirdResult = third.get();
                System.out.println(firstResult + " " + secondResult + " " + thirdResult);
                System.out.println("All tasks have been completed");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
