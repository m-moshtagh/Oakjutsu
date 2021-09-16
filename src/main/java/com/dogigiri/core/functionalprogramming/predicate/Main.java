package com.dogigiri.core.functionalprogramming.predicate;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> (number % 2 == 0);
        Predicate<Integer> isQuotientToFive = number -> (number % 5 == 0);
        System.out.println(isEven.negate().and(isQuotientToFive).test(55));
    }
}
