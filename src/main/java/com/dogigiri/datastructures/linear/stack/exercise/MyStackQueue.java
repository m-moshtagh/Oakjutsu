package com.dogigiri.datastructures.linear.stack.exercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * implement stack using two queues.
 * good comments on Mosh's implementation
 */
public class MyStackQueue {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;
    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    public int pop() {
        if(queue1.isEmpty()) throw new IllegalStateException();
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return queue2.remove();
    }
}
