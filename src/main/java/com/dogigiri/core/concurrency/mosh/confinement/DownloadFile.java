package com.dogigiri.core.concurrency.mosh.confinement;

public class DownloadFile implements Runnable{
    private DownloadStatus status;

    public DownloadFile() {
        status = new DownloadStatus();
    }
    @Override
    public void run() {
        for (var a = 0; a < 1000; a++) {
            if(Thread.currentThread().isInterrupted()) return;
            status.incrementByte();
        }
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
