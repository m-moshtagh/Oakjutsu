package com.dogigiri.datastructures.nonlinear.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionDemoTest {
    RecursionDemo recursionDemo;
    @BeforeEach
    void setUp() {
        recursionDemo = new RecursionDemo();
    }

    @Test
    void factorial() {
        var factorial = recursionDemo.factorial(5);
        assertEquals(120, factorial);
    }

    @Test
    void factorialLoop() {
        var factorial = recursionDemo.factorialLoop(5);
        assertEquals(120, factorial);
    }
}