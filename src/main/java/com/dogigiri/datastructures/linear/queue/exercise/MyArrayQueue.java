package com.dogigiri.datastructures.linear.queue.exercise;

import java.util.Arrays;

/**
 * Implementing a Queue using a simple array. in this approach we will need to pointers to reference the front of queue
 * and the rear of the queue.
 */
public class MyArrayQueue {
    private final int[] items;
    private int front;
    private int rear;
    private int count;

    public MyArrayQueue(int capacity) {
        this.items = new int[capacity];
    }

    /**
     * add item to the queue. we add items to rear of the array. We have to implement circular array because if we remove
     * items from front of array, if we add item and reach end of array we don't get exception.
     * the formula is shown below: so we can loop array to fill the empty spots
     * @param item item to add to queue
     */
    public void enqueue(int item) {
        if(isFull()) throw new IllegalStateException();
        this.items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    /**
     * Remove item from queue.
     * @return item which is removed
     */
    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    /**
     * show the first item in queue
     * @return item on peek of queue
     */
    public int peek() {
        if(isEmpty()) throw new IllegalStateException();
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
