package com.dogigiri.core.concurrency.mosh.synchronizing;

public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;
    private Object totalFilesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementByte() {
        synchronized (this) {
            totalBytes++;
        }
    }

    public void incrementFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    public Object getTotalFiles() {
        return totalFiles;
    }
}
