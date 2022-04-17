package com.dogigiri.designpatterns.cleancode.unclebob.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack = BoundedStack.make(3);

    @Test
    public void newlyInitializedStackShouldBeEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void stackSizeShouldBeOneAfterFirstPush() {
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
    }

    @Test
    public void stackShouldBeEmptyAfterOnePushAndPop() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void stackOverflowTest() {
        assertThrows(BoundedStack.Overflow.class, () -> {
            stack.push(1);
            stack.push(1);
            stack.push(1);
        });
    }

    @Test
    public void stackUnderflowTest() {
        assertThrows(BoundedStack.Underflow.class, () -> stack.pop());
    }

    @Test
    public void illegalCapacityTest() {
        assertThrows(BoundedStack.IllegalCapacity.class, () -> BoundedStack.make(-1));
    }

    @Test
    public void newlyPushedElementShouldBePopped() {
        stack.push(2);
        assertEquals(2, stack.pop());
    }

    @Test
    void createStackWithZeroCapacity() {
        Stack zeroStack = BoundedStack.make(0);
        assertEquals(-1, zeroStack.top());
    }

    @Test
    void stackEmptyTopTest() {
        assertThrows(Stack.Empty.class, () -> stack.top());
    }

    @Test
    void findElementsIndexTest() {
        stack.push(1);
        stack.push(3);
        stack.push(4);
        assertEquals(1, stack.find(3));
    }
}