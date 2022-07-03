package com.dogigiri.core.concurrency.mosh.pausing;

public class DownloadFile implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading file" + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download Completed" + Thread.currentThread().getName());
    }
}
