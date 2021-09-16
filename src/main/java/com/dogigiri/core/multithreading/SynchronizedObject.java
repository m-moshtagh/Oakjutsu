package com.dogigiri.core.multithreading;

public class SynchronizedObject {
    /*
     *  When two threads try to access an objects stats, The application turns a little complicated cause We don't want
     * To get a inappropriate stats. When a Thread tries to get an objects stat it gets the object's lock so This object
     * will be inaccessible to other objects at the time. This is applied by putting synchronization on object.
     * Big note: synchronize Gets meaning only when Two threads try to access same object.
     */
    public void multiplies(int number) throws Exception {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + " -> " + number * i);
                Thread.sleep(400);
            }
        }
    }
}
