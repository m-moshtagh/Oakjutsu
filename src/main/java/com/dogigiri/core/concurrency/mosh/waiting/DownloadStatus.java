package com.dogigiri.core.concurrency.mosh.waiting;

public class DownloadStatus {
    private int totalBytes;
    private volatile boolean isDone;

    public void incrementByte() {
        synchronized (this) {
            totalBytes++;
        }
    }

    public void markDone() {
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getTotalBytes() {
        return totalBytes;
    }
}
