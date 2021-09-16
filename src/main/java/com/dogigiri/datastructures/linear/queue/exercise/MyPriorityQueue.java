package com.dogigiri.datastructures.linear.queue.exercise;

import java.util.Arrays;

/**
 * implement priority queue using simple array approach. this logic can also be implemented using heaps.
 */
public class MyPriorityQueue {
    private final int[] items = new int[5];
    private int count;

    /**
     * to add to queue we need to sort array in a proper way.
     * @param item item need to be added to queue
     */
    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();
        var position = shiftQueueToGetPosition(item);
        items[position] = item;
        count++;
    }

    /**
     * remove the item in peek of the queue, because the array is sorted we just remove the first one
     * @return item on peek of the queue
     */
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        return items[--count];
    }

    /**
     * We start comparing item we want to add to queue from the end of the queue to the first element and if it's
     * greater we shift all them one to right and in the end we add it to queue.
     * @param item need to be placed in right place
     * @return index we can add the item
     */
    private int shiftQueueToGetPosition(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (item < items[i]) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    private boolean isEmpty() {
        return count <= 0;
    }

    private boolean isFull() {
        return (count == items.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
