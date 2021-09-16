package com.dogigiri.datastructures.linear.hashtables.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Creating a simple hashtable with chaining solution
 */
public class MyHashTable {
    /**
     * the basic structure of our hashtable which contains linked lists in it for chaining
     */
    private final List<LinkedList<Entry>> entries = new ArrayList<>();

    /**
     * add one element to prevent divide by zero
     */
    public MyHashTable() {
        entries.add(new LinkedList<>());
    }

    /**
     * store a data using hashcode of the key or update it if it exists
     * @param key key to find index to store
     * @param value value we want to store
     */
    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        var bucket = getOrCreateBucket(key);
        assert bucket != null;
        bucket.add(new Entry(key, value));
    }

    /**
     * get the value which was stored based on the key
     * @param key key to locate the object and fetch it
     * @return the fetched value
     */
    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    /**
     * remove the element by locating it using the hash of the key
     * @param key to locate the index
     */
    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null) throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    /**
     * hash functions helps us find the index to store our data
     * @param key we hash the key to find index
     * @return the index
     */
    private int hash(int key) {
        return key % entries.size();
    }

    /**
     * bucket refers to linked list which is supposed to chain elements which will have same indexed(hash)
     * @param key to locate the index
     * @return the linked list of the index
     */
    private LinkedList<Entry> getBucket(int key) {
        return entries.get(hash(key));
    }

    /**
     * get entry value by iterating bucket of a certain index
     * @param key locate the index
     * @return entry object which  holds the value
     */
    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key) {
                    return entry;
                }
            }
        }
        return null;
    }

    /**
     * create a linked list on an index if it does not exist or get the available one.
     * @param key locate the bucket
     * @return already existed bucket or newly created one
     */
    private LinkedList<Entry> getOrCreateBucket(int key) {
        var bucket = getBucket(key);
        if (bucket == null) entries.add(new LinkedList<>());
        return bucket;
    }

    /**
     * key value structure we are going to use on our hashtable.
     */
    private class Entry {
        private final int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
