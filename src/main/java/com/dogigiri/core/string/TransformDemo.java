package com.dogigiri.core.string;

public class TransformDemo {
    public static void main(String[] args) {
        String text = "Rise from ground";
        String transform = text.transform(s -> s.replace("ground", "hell"));
        System.out.println(transform);
    }
}
