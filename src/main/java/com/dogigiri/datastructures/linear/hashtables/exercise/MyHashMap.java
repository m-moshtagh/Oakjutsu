package com.dogigiri.datastructures.linear.hashtables.exercise;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    private List<Entry> entries = new ArrayList<>(5);
    private int count;

    public void puy(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        entries.set(getIndex(key), new Entry(key, value));
        count++;
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public void remove(int key) {
        var index = getIndex(key);
        if (index == -1 || entries.get(index) == null) return;

        entries.set(index, null);
        count--;
    }

    public int size() {
        return this.count;
    }

    private int hash(int key) {
        return key % entries.size();
    }

    private int prob(int key, int i) {
        return (hash(key) + i) % entries.size();
    }

    private int getIndex(int key) {
        int steps = 0;
        while (steps < entries.size()) {
            int index = prob(key, steps++);
            var entry = entries.get(index);
            if (entry == null || entry.key == key) return index;
        }
        return -1;
    }

    private Entry getEntry(int key) {
        var index = getIndex(key);
        return index >= 0 ? entries.get(index) : null;
    }

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" + "value='" + value + '\'' + '}';
        }
    }
}
