package com.dogigiri.datastructures.stack.exercise;

import com.dogigiri.datastructures.linear.stack.exercise.MyTwoStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTwoStackTest {
    MyTwoStack twoStack;
    @BeforeEach
    void setUp() {
        twoStack = new MyTwoStack(5);
        twoStack.pushToFirstStack(1);
        twoStack.pushToSecondStack(100);
    }

    @Test
    void push1Test() {
        twoStack.pushToFirstStack(5);
        twoStack.pushToFirstStack(10);
        twoStack.pushToFirstStack(20);
        assertThrows(IllegalStateException.class, () -> twoStack.pushToFirstStack(30));
    }

    @Test
    void push2Test() {
        twoStack.pushToSecondStack(5);
        twoStack.pushToSecondStack(10);
        twoStack.pushToSecondStack(20);
        assertThrows(IllegalStateException.class, () -> twoStack.pushToSecondStack(30));
    }

    @Test
    void pop1Test() {
        twoStack.popFromFirstStack();
        twoStack.pushToFirstStack(1000);
        assertEquals(1000, twoStack.popFromFirstStack());
    }

    @Test
    void pop2Test() {
        twoStack.popFromSecondStack();
        twoStack.pushToSecondStack(1000);
        assertEquals(1000, twoStack.popFromSecondStack());
    }
}