package com.dogigiri.core.streams.filtering;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        var list = List.of(1, 10, 11, 12, 13, 21, 20, 25);
        Predicate<Integer> quotientOfTwo = num -> num % 2 == 0;
        list.stream().filter(num -> num > 10 && num < 20).peek(s -> System.out.println("size check pass " + s)).filter(quotientOfTwo).forEach(System.out::println);
    }
}
