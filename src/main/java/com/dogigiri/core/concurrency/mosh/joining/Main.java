package com.dogigiri.core.concurrency.mosh.joining;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new DownloadFile());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("file checked");
    }
}
