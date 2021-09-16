package com.dogigiri.datastructures.linear.stack.builtin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Reverse a string using stack. just push and pop and append to string builder
 */
public class MyStringReverser {
    public String reverse(String input) {
        if (input == null) throw new IllegalStateException();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString();
    }
}
