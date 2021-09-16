package com.dogigiri.algorithms.stringmanipulation.reverse;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStringDemo {
    public String reverse(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for(var character : input.toCharArray())
            stack.push(character);
        var result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop());
        return result.toString();
    }
}
