package com.dogigiri.core.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class DateCheckerTest {
    @Test
    void isBalanced() {
        boolean balanced = DateChecker.isBalanced("2999-12-39");
        assertFalse(balanced);
    }
}