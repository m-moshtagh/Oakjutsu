package com.dogigiri.core.string;

public class FormattedDemo {
    public static void main(String[] args) {
        String text = """
                    Line1: %s1
                    Line2: %s2
                """.formatted("Bleach", "Naruto");
        System.out.println(text);
    }
}
