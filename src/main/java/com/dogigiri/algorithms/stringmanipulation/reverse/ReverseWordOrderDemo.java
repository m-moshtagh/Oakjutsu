package com.dogigiri.algorithms.stringmanipulation.reverse;

public class ReverseWordOrderDemo {
    public String reverseOrder(String input) {
        String[] s = input.split("\\s");
        var result = new StringBuilder();
        for(var i = s.length - 1; i >= 0; i--)
            result.append(s[i]).append(" ");

        return result.toString().trim();
    }
}
