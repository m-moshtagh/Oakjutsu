package com.dogigiri.core.concurrency.executiveframework.handlingtimeouts;

import com.dogigiri.core.concurrency.executiveframework.implementingasynchronousapi.LongOperation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var longTask = CompletableFuture.supplyAsync(() -> {
            LongOperation.takeTime();
            return 20;
        });
        try {
            var result = longTask.completeOnTimeout(10, 1, TimeUnit.SECONDS).get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
