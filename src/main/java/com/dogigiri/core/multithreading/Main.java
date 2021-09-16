package com.dogigiri.core.multithreading;

public class Main {
    public static void main(String[] args) throws Exception{
        /*
         * When we talk about concurrency we mean to run bunch of programs at same time. for example open a recorder and
         * an IDE and Browser at same time. we achieve concurrency in java with the help of threads and processes.
         * process is a standalone execution environment. each process has it's own private resources and memory space.
         * Threads are also called lightweight processes. a process can have some threads and threads are always within
         * a process. each thread is task.
         * Ways to achieve concurrency: 1-We create a class and extend Thread class from Java and implement run() method.
         * this is what will be done when the thread is started.
         * 2- implement Runnable interface and then initialize the Thread java class and pass the class to it.
         * 3- Using anonymous class
         * 4- lambda functions
         * Threads run whenever they find idle state in CPU.
         * Threads have several states: 1- Ready 2- running 3- waiting 4- sleep 5- dead
         *
         */
        SynchronizedObject object1 = new SynchronizedObject();
        Thread thread1 = new Thread(new ExampleThread(object1));
        ExampleThread2 thread2 = new ExampleThread2(object1);

        thread1.start();
        thread2.start();
    }
}
