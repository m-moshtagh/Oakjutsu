package com.dogigiri.algorithms.stringmanipulation.palindrome;

public class PalindromeDemo {
    public boolean isPalindrome(String input) {
        var builder = new StringBuilder(input);
        builder.reverse();
        return builder.toString().equals(input);
    }
}
