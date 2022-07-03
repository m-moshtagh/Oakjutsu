package com.dogigiri.core.concurrency.mosh.executiveframework.implementingasynchronousapi;

public class Main {
    public static void main(String[] args) {
        var future = MailService.sendAsync();
        System.out.println("Nice job learning Good stuff");

        future.thenRunAsync(() -> System.out.println("Wow You really sent email:)"));
        future.thenAccept(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
