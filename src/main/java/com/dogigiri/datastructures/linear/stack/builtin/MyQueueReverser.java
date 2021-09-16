package com.dogigiri.datastructures.linear.stack.builtin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Reverse k elements of queue. Mosh's implementation has good comments
 */
public class MyQueueReverser {
    public Queue<Integer> reverseKElementsOfQueue(Queue<Integer> queue, int kElement) {
        if (kElement < 0 || kElement > queue.size()) throw new IllegalStateException();
        Deque<Integer> stack = new ArrayDeque<>();
        for (var i = 0; i < kElement; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < queue.size() - kElement; i++) {
            queue.add(queue.remove());
        }
        return queue;
    }
}
