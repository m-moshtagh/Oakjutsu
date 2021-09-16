package com.dogigiri.algorithms.stringmanipulation.anagrams;

public class AnagramsHistogramDemo {
    public boolean areAnagrams(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length())
            return false;
        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        for (var i = 0; i < input1.length(); i++) {
            var index = input1.charAt(i) - 'a';
            frequencies[index]++;
        }
        for (var j = 0; j < input2.length(); j++) {
            var index = input2.charAt(j) - 'a';
            if (frequencies[index] == 0)
                return false;
            frequencies[index]--;
        }

        return true;
    }
}
