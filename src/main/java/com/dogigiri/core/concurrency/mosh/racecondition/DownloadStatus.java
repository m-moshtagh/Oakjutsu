package com.dogigiri.core.concurrency.mosh.racecondition;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementByte() {
        this.totalBytes++;
    }
}
