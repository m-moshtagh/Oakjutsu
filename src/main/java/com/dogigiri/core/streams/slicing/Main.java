package com.dogigiri.core.streams.slicing;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var list = Stream.generate(() -> Math.random() * 10).limit(1000).collect(Collectors.toList());
        list.stream().limit(50).forEach(System.out::println);
        /*
            pagination using limit() and skip()
            whole list = 1000 elements
            per page = 10 items
            page we want = 3
            formula: elements we should skip() = 20 && limit(10) -> itemsPerPage * (requestedPage - 1)
         */
        System.out.println("pagination");
        list.stream().skip(20).limit(10).forEach(System.out::println);
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        // takeWhile()
        list.stream().takeWhile(num -> num < 9).forEach(System.out::println);
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        //dropWhile()
        list.stream().dropWhile(num -> num < 9).forEach(System.out::println);
    }
}
