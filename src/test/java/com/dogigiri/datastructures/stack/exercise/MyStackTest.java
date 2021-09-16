package com.dogigiri.datastructures.stack.exercise;

import com.dogigiri.datastructures.linear.stack.exercise.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyStackTest {
    MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
    }

    @Test
    void pushTest() {
        System.out.println(myStack);
        myStack.push(4);
        System.out.println(myStack);
        assertEquals(4, myStack.size());
    }

    @Test
    void popTest() {
        var poppedItem = myStack.pop();
        System.out.println(myStack);
        assertEquals(3, poppedItem);
    }

    @Test
    void peekTest() {
        var peekedItem = myStack.peek();
        assertEquals(3, peekedItem);
        System.out.println(myStack);
    }
}