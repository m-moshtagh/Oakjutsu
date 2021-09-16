package com.dogigiri.core.collections.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> stringCollection = new ArrayList<>();
        Collections.addAll(stringCollection, "Onion", "Olive", "Lemon");
        stringCollection.forEach(System.out::println);
    }
}
