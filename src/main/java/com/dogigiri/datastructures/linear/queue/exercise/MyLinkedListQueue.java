package com.dogigiri.datastructures.linear.queue.exercise;

/**
 * implementing the queue using a linked list from scratch
 * everything is like linked list implementation but with queue logic
 */
public class MyLinkedListQueue {
    private Node head;
    private Node tail;
    private int count;

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        int item;
        if (head == tail) {
            item = head.value;
            head = tail = null;
        } else {
            item = head.value;
            var secondNode = head.nextNode;
            head.nextNode = null;
            head = secondNode;
        }
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return head.value;
    }

    public int size() {
        return count;
    }

    private boolean isEmpty() {
        return (head == null);
    }

    private class Node {
        private int value;
        private Node nextNode;

        Node(int item) {
            value = item;
        }
    }
}
