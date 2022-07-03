package com.dogigiri.core.concurrency.mosh.executiveframework.combiningcompletablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        // we want to get USD and turn it to Rial
        var getDollar = CompletableFuture.supplyAsync(() -> "60 USD")
                .thenApply(string -> {
                    var price = string.replace("USD", "").trim();
                    return Integer.parseInt(price);
                });
        var getRialExchangeRate = CompletableFuture.supplyAsync(() -> 275000);
        getDollar.thenCombine(getRialExchangeRate, (dollar, exchangeRate) -> dollar * exchangeRate).
                thenAccept(System.out::println);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
