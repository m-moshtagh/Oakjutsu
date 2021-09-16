package com.dogigiri.algorithms.stringmanipulation.anagrams;

import java.util.Arrays;

public class AnagramsSortingDemo {
    public boolean areAnagrams(String input1, String input2) {
        if(input1 == null || input2 == null || input1.length() != input2.length())
            return false;
        var charArray1 = input1.toLowerCase().toCharArray();
        var charArray2 = input2.toLowerCase().toCharArray();
        Arrays.sort(input1.toCharArray());
        Arrays.sort(input2.toCharArray());
        return Arrays.equals(charArray1, charArray2);
    }
}
