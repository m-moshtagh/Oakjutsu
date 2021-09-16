package com.dogigiri.datastructures.linear.hashtables.builtin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * find Repeated & Non-repeated characters in a String
 */
public class MyCharFinder {
    /**
     * We use Map to find non-repeated characters
     * @param input String input
     * @return first non-repeated
     */
    public char findFirstNonRepeatedCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();
        var charString = input.toCharArray();
        for (var ch : charString) {
            var count = (map.getOrDefault(ch, 0));
            map.put(ch, count + 1);
        }
        for (var ch : charString) {
            if (map.get(ch) == 1) return ch;
        }
        return Character.MIN_VALUE;
    }

    /**
     * We use HashSet to find the first repeated character in a string
     * @param input string input
     * @return first repeated character
     */
    public char findFirstRepeatedCharacter(String input) {
        Set<Character> set = new HashSet<>();
        var charString = input.toCharArray();
        for (var ch : charString) {
            if(set.contains(ch)) return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
