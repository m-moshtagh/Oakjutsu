package com.dogigiri.core.concurrency.mosh.atomicobjects;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private AtomicInteger totalBytes= new AtomicInteger();

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementByte() {
        this.totalBytes.incrementAndGet();
    }
}
