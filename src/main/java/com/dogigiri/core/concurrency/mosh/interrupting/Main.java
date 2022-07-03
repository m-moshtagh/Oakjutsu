package com.dogigiri.core.concurrency.mosh.interrupting;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new DownloadFile());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
