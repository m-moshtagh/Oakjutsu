package com.dogigiri.core.string;

public class LinesDemo {

    public static void main(String[] args) {
        "Line1\nLine2\nLine3\nLine4\n".lines().forEach(System.out::println);
    }
}
