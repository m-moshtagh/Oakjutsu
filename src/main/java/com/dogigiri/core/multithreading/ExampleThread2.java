package com.dogigiri.core.multithreading;

public class ExampleThread2 extends Thread {
    private SynchronizedObject object;

    public ExampleThread2(SynchronizedObject object) {
        this.object = object;
    }
    @Override
    public void run() {
        try {
            object.multiplies(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
