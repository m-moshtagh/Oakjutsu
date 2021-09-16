package com.dogigiri.datastructures.queue.exercise;

import com.dogigiri.datastructures.linear.queue.exercise.MyStackQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackQueueTest {
    MyStackQueue stackQueue = new MyStackQueue();
    @BeforeEach
    void setUp() {
        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);
    }

    @Test
    void enqueue() {
        stackQueue.enqueue(40);
    }

    @Test
    void dequeue() {
        int dequeue = stackQueue.dequeue();
        assertEquals(10, dequeue);
    }

    @Test
    void peek() {
        int peek = stackQueue.peek();
        assertEquals(10, peek);
        assertEquals(10, stackQueue.dequeue());
    }
}