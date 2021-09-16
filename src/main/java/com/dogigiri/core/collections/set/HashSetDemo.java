package com.dogigiri.core.collections.set;

import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new java.util.HashSet<>();
        set.add(5);
        set.add(8);
        set.add(5);
        System.out.println(set);
    }
}
