package com.dogigiri.algorithms.stringmanipulation.sentencecapitalization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceCapitalizationDemoTest {
    SentenceCapitalizationDemo sentenceCapitalizationDemo;
    String input;
    @BeforeEach
    void setUp() {
        sentenceCapitalizationDemo = new SentenceCapitalizationDemo();
        input = "there is   a tree         in the house ";
    }

    @Test
    void capitalize() {
        System.out.println(sentenceCapitalizationDemo.capitalize(input));
    }
}