package com.dogigiri.core.concurrency.mosh.volatiling;

public class DownloadFile implements Runnable {
    private DownloadStatus status;

    public DownloadFile(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for (var a = 0; a < 1_000_000; a++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementByte();
        }
        status.markDone();
        System.out.println("Download completed" + status.getTotalBytes());
    }
}
