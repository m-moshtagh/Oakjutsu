package com.dogigiri.core.collections.map;

import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.HashMap<>();
        map.put(1, "Mohammad");
        map.put(2, "Aida");
        map.put(3, "Ali");
        map.put(4, "Reza");

        if (map.containsKey(1)) {
            System.out.println(map.get(1));
        }

        for (var a : map.keySet()) {
            System.out.println(map.get(a));
        }
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
