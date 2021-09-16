package com.dogigiri.datastructures.nonlinear.heap;

public class MoshPriorityQueue {
    private MoshHeap heap = new MoshHeap();

    // O(log n)
    public void enqueue(int item) {
        heap.insert(item);
    }

    // O(log n)
    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
