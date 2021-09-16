package com.dogigiri.datastructures.linear.stack.exercise;

import java.util.Arrays;

/**
 * This is two-way stack using one array
 * We divide array into two parts and two pointers to point to their starting points.
 */
public class MyTwoStack {
    private final int[] array;
    private int firstStackTop;
    private int secondStackTop;

    public MyTwoStack(int capacity) {
        array = new int[capacity];
        firstStackTop = -1;
        secondStackTop = array.length;
    }

    public void pushToFirstStack(int item) {
        if(isFirstStackFull()) throw new IllegalStateException();
        array[++firstStackTop] = item;
    }

    public void pushToSecondStack(int item) {
        if(isSecondStackFull()) throw new IllegalStateException();
        array[--secondStackTop] = item;
    }

    public int popFromFirstStack() {
        if(isFirstStackEmpty()) throw new IllegalStateException();
        return array[firstStackTop--];
    }

    public int popFromSecondStack() {
        if(isSecondStackEmpty()) throw new IllegalStateException();
        return array[secondStackTop++];
    }

    public boolean isFirstStackEmpty() {
        return firstStackTop == -1;
    }

    public boolean isSecondStackEmpty() {
        return secondStackTop == array.length;
    }

    public boolean isFirstStackFull() {
        return firstStackTop == secondStackTop - 1;
    }

    public boolean isSecondStackFull() {
        return secondStackTop == firstStackTop + 1;
    }

    public String print() {
        return Arrays.toString(array);
    }
}
