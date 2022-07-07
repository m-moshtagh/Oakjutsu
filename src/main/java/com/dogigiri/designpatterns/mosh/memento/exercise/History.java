package com.dogigiri.designpatterns.mosh.memento.exercise;

import java.util.Stack;

public class History<E extends Memento> {
    private final Stack<E> states = new Stack<>();

    public void push(E state) {
        states.push(state);
    }

    public E pop() {
        return states.pop();
    }
}
