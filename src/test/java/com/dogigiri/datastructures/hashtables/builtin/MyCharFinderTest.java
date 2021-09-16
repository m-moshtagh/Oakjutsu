package com.dogigiri.datastructures.hashtables.builtin;

import com.dogigiri.datastructures.linear.hashtables.builtin.MyCharFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCharFinderTest {
    MyCharFinder charFinder;
    @BeforeEach
    void setUp() {
        charFinder = new MyCharFinder();
    }

    @Test
    void findFirstNonRepeatedCharacterTest() {
        assertEquals('g', charFinder.findFirstNonRepeatedCharacter("a green apple"));
    }

    @Test
    void findFirstRepeatedCharacterTest() {
        assertEquals('e', charFinder.findFirstRepeatedCharacter("a green apple"));
    }
}