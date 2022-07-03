package com.dogigiri.core.concurrency.mosh.confinement;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementByte() {
        this.totalBytes++;
    }
}
