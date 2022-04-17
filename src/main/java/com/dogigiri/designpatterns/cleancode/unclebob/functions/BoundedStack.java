package com.dogigiri.designpatterns.cleancode.unclebob.functions;

public class BoundedStack implements Stack {
    private final int capacity;
    private final int[] elements;
    private int size;

    private BoundedStack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public static Stack make(int capacity) {
        if (capacity < 0)
            throw new IllegalCapacity();
        if (capacity == 0)
            return new ZeroCapacityStack();
        return new BoundedStack(capacity);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(int number) {
        if (size == capacity)
            throw new Overflow();
        elements[size++] = number;
    }

    @Override
    public int pop() {
        if (isEmpty())
            throw new Underflow();
        return elements[--size];
    }

    @Override
    public int top() {
        if(isEmpty())
            throw new Empty();
        return elements[size - 1];
    }

    @Override
    public int find(int element) {
        if(isEmpty())
            throw new Empty();
        for (int i = size - 1; i >= 0; i--) {
            if(elements[i] == element)
                return (size - 1) - i;
        }
        return -1;
    }

    public static class Overflow extends RuntimeException {
    }

    public static class Underflow extends RuntimeException {
    }

    private static class ZeroCapacityStack implements Stack {
        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void push(int number) {
            throw new Overflow();
        }

        @Override
        public int pop() {
            throw new Underflow();
        }

        @Override
        public int top() {
            throw new Empty();
        }

        @Override
        public int find(int element) {
            return -1;
        }
    }
}
