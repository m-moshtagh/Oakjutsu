package com.dogigiri.core.concurrency.mosh.interrupting;

public class DownloadFile implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("Downloaded: " + i);
            if (Thread.currentThread().isInterrupted()) return;
        }
    }
}
