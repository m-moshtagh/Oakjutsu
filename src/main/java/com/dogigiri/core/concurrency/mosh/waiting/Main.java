package com.dogigiri.core.concurrency.mosh.waiting;

public class Main {
    public static void main(String[] args) {
        DownloadStatus status = new DownloadStatus();
        Thread thread1 = new Thread(new DownloadFile(status));
        Thread thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes() + " isDone");
        });
        thread1.start();
        thread2.start();
    }
}
