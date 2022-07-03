package com.dogigiri.core.concurrency.mosh.racecondition;

public class DownloadFile implements Runnable {
    private DownloadStatus status;

    public DownloadFile(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for (var a = 0; a < 10_000; a++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementByte();
        }
    }
}
