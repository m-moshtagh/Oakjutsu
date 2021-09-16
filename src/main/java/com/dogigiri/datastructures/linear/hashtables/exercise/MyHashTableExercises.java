package com.dogigiri.datastructures.linear.hashtables.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashTableExercises {
    public int countPairsWithDiff(List<Integer> numbers, int difference) {
        // (number + diff & number) pair
        //  OR
        // (number - diff & number) pair
        Set<Integer> set = new HashSet<>(numbers);
        int count = 0;
        for (var number : numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }
        return count;
    }

    public int mostFrequent(List<Integer> numbers) {
        var map = new HashMap<Integer, Integer>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }
        int max = -1;
        int result = numbers.get(0);
        for (var entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        // a + b = target => b = target - a
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int b = target - numbers[i];
            if (map.containsKey(b)) {
                return new int[]{map.get(b), i};
            }
            map.put(numbers[i], i);
        }
        return new int[0];
    }
}
