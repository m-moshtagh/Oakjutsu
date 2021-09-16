package com.dogigiri.datastructures.linear.queue.builtin;

import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);
        LoggerFactory.getLogger(ArrayDequeDemo.class).info("{}", queue);
    }

    public static void reverse(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
