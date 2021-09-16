package com.dogigiri.core.concurrency.racecondition;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementByte() {
        this.totalBytes++;
    }
}
