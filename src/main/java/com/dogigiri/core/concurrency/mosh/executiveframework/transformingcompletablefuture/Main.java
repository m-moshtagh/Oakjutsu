package com.dogigiri.core.concurrency.mosh.executiveframework.transformingcompletablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static int toFahrenheit(int Celsius) {
        return (int) (Celsius * 1.8) + 32;
    }
    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 24);
        future.thenApply(Main::toFahrenheit).thenAccept(System.out::println);
    }
}
