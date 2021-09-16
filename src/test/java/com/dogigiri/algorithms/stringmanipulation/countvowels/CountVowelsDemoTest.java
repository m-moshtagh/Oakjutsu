package com.dogigiri.algorithms.stringmanipulation.countvowels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountVowelsDemoTest {
    CountVowelsDemo countVowelsDemo;
    String input;
    @BeforeEach
    void setUp() {
        countVowelsDemo = new CountVowelsDemo();
        input = "";
    }

    @Test
    void countVowel() {
        assertEquals(2, countVowelsDemo.countVowel(input));
    }
}