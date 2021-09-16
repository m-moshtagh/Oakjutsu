package com.dogigiri.algorithms.stringmanipulation.reverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordOrderDemoTest {
    ReverseWordOrderDemo reverseWordOrderDemo;
    String input;
    @BeforeEach
    void setUp() {
        reverseWordOrderDemo = new ReverseWordOrderDemo();
        input = "Trees are beautiful";
    }

    @Test
    void reverseOrder() {
        var result = reverseWordOrderDemo.reverseOrder(input);
        System.out.println(result);
    }
}