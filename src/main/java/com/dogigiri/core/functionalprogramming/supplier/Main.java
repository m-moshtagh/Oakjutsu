package com.dogigiri.core.functionalprogramming.supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> (int)(Math.random() * 100);
        System.out.println(random.get());
    }
}
