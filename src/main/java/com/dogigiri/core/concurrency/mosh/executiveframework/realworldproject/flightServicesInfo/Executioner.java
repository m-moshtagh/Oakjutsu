package com.dogigiri.core.concurrency.mosh.executiveframework.realworldproject.flightServicesInfo;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class Executioner {
    public static void main(String[] args) {
        var startTime = LocalTime.now();
        var service = new FlightService();
        CompletableFuture.allOf(service.getQuotes("site1", "site2", "site3")
                .map(quoteCompletableFuture -> quoteCompletableFuture.thenAccept(System.out::println))
                .toArray(CompletableFuture[]::new)).thenRun(() -> {
            LocalTime finishTime = LocalTime.now();
            Duration duration = Duration.between(startTime, finishTime);
            System.out.println("Took " + duration.toSeconds() + " secs" + " to finish the job");
        });
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
