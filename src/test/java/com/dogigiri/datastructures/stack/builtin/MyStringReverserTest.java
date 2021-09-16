package com.dogigiri.datastructures.stack.builtin;

import com.dogigiri.datastructures.linear.stack.builtin.MyStringReverser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStringReverserTest {
    @Test
    void reverseTest() {
        assertEquals("anc", new MyStringReverser().reverse("cna"));
    }
}