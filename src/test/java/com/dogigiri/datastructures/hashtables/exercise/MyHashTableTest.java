package com.dogigiri.datastructures.hashtables.exercise;

import com.dogigiri.datastructures.linear.hashtables.exercise.MyHashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {
    MyHashTable hashTable;
    @BeforeEach
    void setUp() {
        hashTable = new MyHashTable();
        hashTable.put(0, "S");
    }

    @Test
    void putTest() {
        hashTable.put(5, "A");
        hashTable.put(8, "B");
        hashTable.put(10, "C");
        hashTable.put(12, "A+");
        assertEquals("A+", hashTable.get(12));
    }

    @Test
    void removeTest() {
        hashTable.remove(0);
        assertNull(hashTable.get(0));
    }

    @Test
    void getTest() {
        String s = hashTable.get(0);
        assertEquals("S", s);
    }
}