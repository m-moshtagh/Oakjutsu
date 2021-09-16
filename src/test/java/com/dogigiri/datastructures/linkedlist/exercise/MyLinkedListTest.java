package com.dogigiri.datastructures.linkedlist.exercise;

import com.dogigiri.datastructures.linear.linkedlist.exercise.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new MyLinkedList();
        linkedList.addFirst(1);
        linkedList.addLast(10);
        linkedList.addLast(100);
    }

    @Test
    void addFirstTest() {
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        assertEquals(5, linkedList.size());
    }

    @Test
    void addLastTest() {
        linkedList.addLast(40);
        assertEquals(4, linkedList.size());
    }

    @Test
    void removeFirst() {
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        assertThrows(IllegalStateException.class, () -> linkedList.removeFirst());
    }

    @Test
    void removeLastTest() {
        linkedList.removeLast();
        assertEquals(2, linkedList.size());
    }

    @Test
    void indexOfTest() {
        var index = linkedList.indexOf(100);
        assertEquals(2, index);
    }

    @Test
    void isEmptyTest() {
        MyLinkedList myLinkedList = new MyLinkedList();
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    void containsTest() {
        assertTrue(linkedList.contains(100));
    }

    @Test
    void toArrayTest() {
        var array = linkedList.toArray();
        int[] expected = {1, 10, 100};
        assertArrayEquals(expected, array);
    }

    @Test
    void reverseTest() {
        linkedList.reverse();
        assertEquals(3, linkedList.size());
    }

    @Test
    void getKthFromTheEndTest() {
        linkedList.addLast(200);
        linkedList.addLast(300);
        assertEquals(300, linkedList.getKthFromTheEnd(-5));
    }

    @Test
    void printMiddleTest() {
        linkedList.printMiddle();
        assertEquals(3, linkedList.size());
    }

    @Test
    void hasLoopTest() {
        linkedList.addLast(200);
        linkedList.addLast(300);
        linkedList.addLast(400);
        boolean b = linkedList.hasLoop();
        LoggerFactory.getLogger(MyLinkedListTest.class).info("{}", b);
        assertFalse(linkedList.isEmpty());
    }
}