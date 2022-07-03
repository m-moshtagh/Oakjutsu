package com.dogigiri.core.concurrency.mosh.executiveframework.composingcompletablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static CompletableFuture<String> getEmailsAsync() {
        return CompletableFuture.supplyAsync(() -> "emails");
    }

    public static CompletableFuture<String> getPlayListAsync(String emails) {
        return CompletableFuture.supplyAsync(() -> "playList");
    }

    public static void main(String[] args) {
        getEmailsAsync().thenCompose(Main::getPlayListAsync).thenAccept(System.out::println);

        // We want to get Emails by ID Then We want to get playlist using Email
//        CompletableFuture.supplyAsync(() -> "emails")
//                .thenCompose(email -> CompletableFuture.supplyAsync(() -> "playList"))
//                .thenAccept(System.out::println);
    }
}
