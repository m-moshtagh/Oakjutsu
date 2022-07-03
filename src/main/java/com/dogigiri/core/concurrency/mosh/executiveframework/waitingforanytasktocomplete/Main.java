package com.dogigiri.core.concurrency.mosh.executiveframework.waitingforanytasktocomplete;

import com.dogigiri.core.concurrency.mosh.executiveframework.implementingasynchronousapi.LongOperation;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        var firstTask = CompletableFuture.supplyAsync(() -> {
            LongOperation.takeTime();
            return 20;
        });
        var secondTask = CompletableFuture.supplyAsync(() -> 30);

        CompletableFuture.anyOf(firstTask, secondTask).thenAccept(System.out::println);
    }
}
