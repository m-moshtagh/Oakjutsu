package com.dogigiri.core.functionalprogramming.function;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> replaceColumn = s -> s.replace(":", "=");
        Function<String, String> wrapStringWithCurlyBraces = s -> "{" + s + "}";
        System.out.println(replaceColumn.andThen(wrapStringWithCurlyBraces).apply("name: mohammad"));
    }
}
