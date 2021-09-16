package com.dogigiri.algorithms.stringmanipulation.palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeDemoTest {
    PalindromeDemo palindromeDemo;
    String input;
    @BeforeEach
    void setUp() {
        input = "TENET";
        palindromeDemo = new PalindromeDemo();
    }

    @Test
    void isPalindrome() {
        System.out.println(palindromeDemo.isPalindrome(input));
    }
}