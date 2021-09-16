package com.dogigiri.datastructures.nonlinear.heap;

public class MoshMinPriorityQueue {
    private MoshMinHeap heap = new MoshMinHeap();

    public void add(String value, int priority) {
        heap.insert(priority, value);
    }

    public String remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
