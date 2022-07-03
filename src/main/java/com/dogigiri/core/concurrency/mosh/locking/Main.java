package com.dogigiri.core.concurrency.mosh.locking;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DownloadStatus status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();
        for (var a = 0; a < 10; a++) {
            Thread thread = new Thread(new DownloadFile(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(status.getTotalBytes());
    }
}
