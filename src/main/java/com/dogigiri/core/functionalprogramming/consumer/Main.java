package com.dogigiri.core.functionalprogramming.consumer;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("java", "c", "c++");
        Consumer<String> print = s -> System.out.println(s);
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        list.forEach(print.andThen(printUpperCase).andThen(print));
    }
}
