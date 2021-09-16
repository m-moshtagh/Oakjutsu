package com.dogigiri.core.multithreading;

public class ExampleThread implements Runnable {
    private SynchronizedObject object;

    public ExampleThread(SynchronizedObject object) {
        this.object = object;
    }
    @Override
    public void run(){
        try {
            object.multiplies(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
