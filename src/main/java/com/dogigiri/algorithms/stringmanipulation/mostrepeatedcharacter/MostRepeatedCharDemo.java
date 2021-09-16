package com.dogigiri.algorithms.stringmanipulation.mostrepeatedcharacter;

import java.util.HashMap;

public class MostRepeatedCharDemo {
    public void mostRepeatedCharacter(String input) {
        var map = new HashMap<Character, Integer>();
        for (var item : input.toCharArray()) {
            if (map.containsKey(item))
                map.replace(item, map.get(item) + 1);
            else
                map.put(item, 1);
        }
    }
}
