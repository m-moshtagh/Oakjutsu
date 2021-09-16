package com.dogigiri.datastructures.arrays.exercise;

import static org.junit.jupiter.api.Assertions.*;

import com.dogigiri.datastructures.linear.arrays.exercise.MyDynamicArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyDynamicArrayTest {
    MyDynamicArray array;

    @BeforeEach
    void setUp() {
        array = new MyDynamicArray();
        array.add(1);
        array.add(10);
        array.add(5030);
    }

    @Test
    void addTest() {
        array.add(20);
        array.add(30);
        array.add(40);
        array.add(50);
        array.addAt(0, 0);
        assertEquals(8, array.size());
    }

    @Test
    void removeTest() {
        array.removeAt(0);
        array.remove(10);
        System.out.println(array);
    }

    @Test
    void reversedTest() {
        array.reverse();
        System.out.println(array);
    }

    @Test
    void intersectTest() {
        var newArray = new MyDynamicArray(5);
        newArray.add(20);
        newArray.add(1);
        newArray.add(50);
        newArray.add(5030);
        newArray.add(10);
        var intersect = array.intersect(newArray);
        System.out.println(intersect);
    }

    @Test
    void minMaxTest() {
        int max = array.max();
        int min = array.min();
        assertAll(() -> {
            assertEquals(1, min);
            assertEquals(5030, max);
        });
    }
}