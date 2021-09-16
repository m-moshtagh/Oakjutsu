package com.dogigiri.algorithms.stringmanipulation.removeduplicates;

import java.util.HashSet;

public class RemoveDuplicatesDemo {
    public String removeDuplicate(String input) {
        var result = new StringBuilder();
        var set = new HashSet<Character>();
        for (var character : input.toCharArray()) {
            if(set.contains(character)){
                set.add(character);
                result.append(character);
            }
        }
        return result.toString();
    }
}
