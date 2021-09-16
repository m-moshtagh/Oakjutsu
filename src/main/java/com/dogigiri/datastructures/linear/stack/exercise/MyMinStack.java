package com.dogigiri.datastructures.linear.stack.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * Here we implement a stack which pops the minimum element
 */
public class MyMinStack {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    /**
     * We push item to stack and if it's smaller than the peek of the minStack we also push there.
     * @param item item need to be added to stack
     */
    public void push(int item) {
        stack.push(item);
        if (minStack.isEmpty()) minStack.push(item);
        assert minStack.peek() != null;
        if (item < minStack.peek()) minStack.push(item);
    }

    /**
     * we pop() from main  stack and if it equals to min stack peek we return it too.
     * @return
     */
    public int pop() {
        if (stack.isEmpty()) throw new IllegalStateException();
        var top = stack.pop();
        if (Objects.equals(minStack.peek(), top)) minStack.pop();
        return top;
    }

    public int min() {
        assert minStack.peek() != null;
        return minStack.peek();
    }

}
