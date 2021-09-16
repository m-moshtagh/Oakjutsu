package com.dogigiri.core.string;

import org.slf4j.LoggerFactory;

/**
 * strip() is "Unicode-aware" evolution of trim(). Meaning trim() removes only characters <= U+0020 (space);
 * strip() removes all Unicode whitespace characters (but not all control characters, such as \0)
 */
public class StripDemo {
    public static void main(String[] args) {
        String text = "    Rise ";
        String strippedText = text.stripTrailing().replace(" ", "@");
        LoggerFactory.getLogger(StripDemo.class).info(strippedText);
    }
}
