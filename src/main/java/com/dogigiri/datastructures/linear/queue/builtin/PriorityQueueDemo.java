package com.dogigiri.datastructures.linear.queue.builtin;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(30);
        queue.add(20);
        while (!queue.isEmpty()) System.out.println(queue.remove());
    }
}
