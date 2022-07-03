package com.dogigiri.core.concurrency.mosh.adderobjects;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    private LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
        return totalBytes.intValue();
    }

    public void incrementByte() {
        this.totalBytes.increment();
    }
}
