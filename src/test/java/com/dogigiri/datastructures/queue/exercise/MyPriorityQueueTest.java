package com.dogigiri.datastructures.queue.exercise;

import com.dogigiri.datastructures.linear.queue.exercise.MyPriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyPriorityQueueTest {
    MyPriorityQueue queue = new MyPriorityQueue();
    @BeforeEach
    void setUp() {
        queue.enqueue(10);
        queue.enqueue(5);
        System.out.println(queue);
    }

    @Test
    void enqueue() {
        queue.enqueue(40);
        queue.enqueue(30);
        System.out.println(queue);
    }

    @Test
    void dequeue() {
        int dequeue = queue.dequeue();
        System.out.println(dequeue);
    }
}