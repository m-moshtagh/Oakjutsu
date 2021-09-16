package com.dogigiri.core.string;

import org.slf4j.LoggerFactory;

/**
 * Text blocks helps us avoid putting lots of escape characters and trimming when we want to
 * create multiple line Strings like JSON.
 * Compiler will automatically remove the unessential whitespace.
 */
public class TextBlocksDemo {
    public static void main(String[] args) {
        String text = """
                    {
                        Line1: %s1
                        Line2: %s2
                    }""".formatted("Bleach", "Naruto");
        LoggerFactory.getLogger(TextBlocksDemo.class).info(text);
    }
}
