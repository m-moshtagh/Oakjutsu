package com.dogigiri.datastructures.linear.stack.exercise;

import java.util.Arrays;

/**
 * we implement a push pop stack using simple array
 */
public class MyStack {
    private final int[] stack = new int[5];
    private int count;

    public void push(int item) {
        if (isFull()) throw new IllegalStateException();
        stack[count++] = item;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return stack[--count];
    }

    public int peek() {
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == stack.length;
    }

    public int size() {
        return count;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(stack, 0, count));
    }
}
