package com.dogigiri.datastructures.hashtables.exercise;

import com.dogigiri.datastructures.linear.hashtables.exercise.MyHashTableExercises;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MyHashTableExercisesTest {
    MyHashTableExercises exercises;
    @BeforeEach
    void setUp() {
        exercises = new MyHashTableExercises();
    }

    @Test
    void countPairsWithDiff() {
        int i = exercises.countPairsWithDiff(List.of(2, 5, 7, 10, 3), 2);
        System.out.println(i);
    }

    @Test
    void mostFrequentTest() {
        int i = exercises.mostFrequent(List.of(2, 5, 7, 10, 3, 5, 3, 10, 11, 10));
        System.out.println(i);
    }

    @Test
    void twoSumTest() {
        int[] array = {1, 5, 3, 8, 7, 10, 4};
        int[] ints = exercises.twoSum(array, 10);
        System.out.println(Arrays.toString(ints));
    }
}