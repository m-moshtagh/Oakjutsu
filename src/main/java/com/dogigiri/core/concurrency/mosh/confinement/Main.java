package com.dogigiri.core.concurrency.mosh.confinement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        List<DownloadFile> downloader = new ArrayList<>();
        for (var a = 0; a < 10; a++) {
            DownloadFile downloadFile = new DownloadFile();
            downloader.add(downloadFile);
            Thread thread = new Thread(downloadFile);
            threadList.add(thread);
            thread.start();

        }
        for (var thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(downloader.stream().map(t -> t.getStatus().getTotalBytes()).reduce(Integer::sum));
    }
}
