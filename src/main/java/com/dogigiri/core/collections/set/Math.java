package com.dogigiri.core.collections.set;

import java.util.*;

public class Math {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));

//        set1.addAll(set2);
        System.out.println(set1);

//        set1.retainAll(set2);
        System.out.println(set1);

        set1.removeAll(set2);
        System.out.println(set1);
    }
}
