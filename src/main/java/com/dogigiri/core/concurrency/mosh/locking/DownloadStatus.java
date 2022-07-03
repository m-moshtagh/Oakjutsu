package com.dogigiri.core.concurrency.mosh.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementByte() {
        try{
            lock.lock();
            this.totalBytes++;
        }
        finally {
            lock.unlock();
        }
    }
}
