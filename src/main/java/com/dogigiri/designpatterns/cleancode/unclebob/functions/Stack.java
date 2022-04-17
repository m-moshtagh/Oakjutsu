package com.dogigiri.designpatterns.cleancode.unclebob.functions;

public interface Stack {

    int getSize();

    boolean isEmpty();

    void push(int number);

    int pop();

    int top();

    int find(int element);

    class IllegalCapacity extends RuntimeException {
    }

    class Empty extends RuntimeException {
    }

}
