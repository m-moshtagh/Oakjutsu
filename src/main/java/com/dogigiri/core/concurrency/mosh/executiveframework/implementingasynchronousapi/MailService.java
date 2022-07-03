package com.dogigiri.core.concurrency.mosh.executiveframework.implementingasynchronousapi;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public static int send() {
        LongOperation.takeTime();
        System.out.println("Email was sent");
        return 1;
    }

    public static CompletableFuture<Integer> sendAsync() {
        return CompletableFuture.supplyAsync(MailService::send);
    }
}
