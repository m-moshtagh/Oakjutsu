package com.dogigiri.core.concurrency.mosh.executiveframework.realworldproject.flightServicesInfo;

import com.dogigiri.core.concurrency.mosh.executiveframework.implementingasynchronousapi.LongOperation;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public Stream<CompletableFuture<Quote>> getQuotes(String... sites) {
        var list = List.of(sites);
        return list.stream().map(this::getQuote);
    }
    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);
            var random = new Random();
            LongOperation.takeTime(1001 + random.nextLong(2000));
            var price = 100 + random.nextLong(10);
            return new Quote(site, price);
        });
    }
}
