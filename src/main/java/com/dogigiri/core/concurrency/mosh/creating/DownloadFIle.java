package com.dogigiri.core.concurrency.mosh.creating;

public class DownloadFIle implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading the file" + Thread.currentThread().getName());
    }
}
