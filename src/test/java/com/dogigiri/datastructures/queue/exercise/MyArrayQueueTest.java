package com.dogigiri.datastructures.queue.exercise;

import com.dogigiri.datastructures.linear.queue.exercise.MyArrayQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayQueueTest {
    MyArrayQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MyArrayQueue(5);
        queue.enqueue(10);
    }

    @Test
    void enqueueTest() {
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue);
        assertThrows(IllegalStateException.class, () -> queue.enqueue(60));
    }

    @Test
    void dequeueTest() {
        System.out.println(queue.dequeue());
        System.out.println(queue);
        assertThrows(IllegalStateException.class, queue::dequeue);
        queue.enqueue(20);
        queue.enqueue(20);
        queue.enqueue(20);
        queue.enqueue(20);
        queue.enqueue(20);
        System.out.println(queue);
    }
}