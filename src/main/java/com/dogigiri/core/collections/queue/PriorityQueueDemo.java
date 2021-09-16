package com.dogigiri.core.collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        java.util.Queue<String> queue = new PriorityQueue<>();
        queue.add("Mohammad");
        queue.add("Aida");
        queue.add("Ali");
        // queue sorts elements in queue as alphabetic.
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);

        // removes element and returns it.
        String poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue);
    }
}
