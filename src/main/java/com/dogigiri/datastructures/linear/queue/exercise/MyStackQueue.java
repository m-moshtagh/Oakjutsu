package com.dogigiri.datastructures.linear.queue.exercise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * implement queue using two stacks
 * There is good comment on Mosh's implementation
 */
public class MyStackQueue {
    private final Deque<Integer> stack1 = new ArrayDeque<>();
    private final Deque<Integer> stack2 = new ArrayDeque<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();
        moveToSecondStack();
        return stack2.pop();
    }

    private void moveToSecondStack() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();
        moveToSecondStack();
        assert stack2.peek() != null;
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
