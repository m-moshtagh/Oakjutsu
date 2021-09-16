package com.dogigiri.core.streams.streamcreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // from collection
        var list = new ArrayList<Integer>();
        list.stream().filter(num -> num < 0);

        // Arrays
        int[] intArray = {1, 2, 3, 4, 5};
        Arrays.stream(intArray).forEach(System.out::println);

        // stream.generate() method to create infinite stream
        Stream.generate(() -> Math.random() * 100).limit(10).forEach(System.out::println);

        // stream.iterate() method can also create infinite stream which can be limited by limit() method
        Stream.iterate(1, num -> num + 1).limit(10).forEach(System.out::println);

        // stream.of() to create finite stream
        Stream.of(1, 2, 3, 4, 5, 6).forEach(System.out::println);
    }
}
