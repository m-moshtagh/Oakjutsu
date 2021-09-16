package com.dogigiri.algorithms.stringmanipulation.countvowels;

import java.util.Set;

public class CountVowelsDemo {
    public int countVowel(String input) {
        Set<Character> vowels = Set.of('a', 'e', 'o', 'u', 'i');
        var count = 0;
        for(var character : input.toLowerCase().toCharArray())
            if (vowels.contains(character))
                count++;
        return count;
    }
}
