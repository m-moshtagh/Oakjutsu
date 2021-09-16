package com.dogigiri.algorithms.stringmanipulation.reverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringDemoTest {
    ReverseStringDemo reverseDemo;
    String input;
    @BeforeEach
    void setUp() {
        reverseDemo = new ReverseStringDemo();
        input = "about";
    }

    @Test
    void reverse() {
        assertEquals("tuoba", reverseDemo.reverse(input));
    }
}