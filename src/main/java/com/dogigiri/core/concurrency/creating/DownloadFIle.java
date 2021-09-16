package com.dogigiri.core.concurrency.creating;

public class DownloadFIle implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading the file" + Thread.currentThread().getName());
    }
}
