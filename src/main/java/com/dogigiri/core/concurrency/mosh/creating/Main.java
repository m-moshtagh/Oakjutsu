package com.dogigiri.core.concurrency.mosh.creating;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        int i = 0;
        while (i < 10) {
            new Thread(new DownloadFIle()).start();
            i++;
        }
    }
}
