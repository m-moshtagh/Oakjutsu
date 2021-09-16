package com.dogigiri.datastructures.linear.arrays.exercise;

import java.util.Arrays;

/**
 * MyDynamicArray is a simple dynamic array like ArrayList class.
 * @author dogigiri
 */
public class MyDynamicArray {
    private int[] elements;
    private int count;

    public MyDynamicArray() {
        this.elements = new int[2];
        this.count = 0;
    }

    public MyDynamicArray(int capacity) {
        this.elements = new int[capacity];
        this.count = 0;
    }

    /**
     * We need to resize the array if we have reached the end of array.
     * Then we can add the new item to the array.
     * @param element new item we want to insert to array
     */
    public void add(int element) {
        resizeArrayIfRequired();
        elements[count++] = element;
    }

    /**
     * We add element at a preferred index.
     * @param index preferred index
     * @param element new item
     */
    public void addAt(int index, int element) {
        if (index < 0 || index > count) throw new IllegalArgumentException();
        resizeArrayIfRequired();
        System.arraycopy(elements, index, elements, index + 1, count - 1 - index);
        elements[index] = element;
        count++;
    }

    /**
     * Get element located at specific index.
     * @param index index of the element
     * @return element in the specific index
     */
    public int get(int index) {
        if (index >= count) throw new IllegalStateException();
        return elements[index];
    }

    /**
     * Remove specific element and shift all elements one to left
     * @param index element index we want to remove
     */
    public void removeAt(int index) {
        if (index < 0 || index >= count) throw new IllegalStateException();
        System.arraycopy(elements, index + 1, elements, index, count - 1 - index);
        elements[count - 1] = 0;
        count--;
    }

    /**
     * remove specific element from array
     * @param element element we want to remove
     */
    public void remove(int element) {
        if (indexOf(element) < 0) throw new IllegalStateException();
        if (count - 1 - indexOf(element) >= 0)
            System.arraycopy(elements, indexOf(element) + 1, elements, indexOf(element), count - 1 - indexOf(element));
        elements[count - 1] = 0;
        count--;
    }

    /**
     * return index of specific element or see if it exists or not
     * @param element element we want to find
     * @return index of current element
     */
    public int indexOf(int element) {
        for (var i = 0; i < count; i++) {
            if (elements[i] == element) return i;
        }
        return -1;
    }

    /**
     * get the size of the array
     * @return size
     */
    public int size() {
        return count;
    }

    /**
     * find the largest element in array
     * @return largest element
     */
    public int max() {
        if (count == 0) throw new IllegalStateException();
        int max = elements[0];
        for (var i = 1; i < count; i++) {
            if (max < elements[i]) max = elements[i];
        }
        return max;
    }

    /**
     * loop through array and find the minimum element
     * @return smallest element
     */
    public int min() {
        if (count == 0) throw new IllegalStateException();
        int min = elements[0];
        for (var i = 1; i < count; i++) {
            if (min > elements[i]) min = elements[i];
        }
        return min;
    }

    /**
     * return elements that don't exist in second array.
     * @param array array we want to intersect
     * @return elements that only exists in first array
     */
    public MyDynamicArray intersect(MyDynamicArray array) {
        var intersect = new MyDynamicArray(count);
        for (var i : elements) {
            if (array.indexOf(i) >= 0)
                intersect.add(i);
        }
        return intersect;
    }

    /**
     * reverse array by creating new array and fill it backwards
     */
    public void reverse() {
        var reversed = new int[count];
        for (var i = 0; i < count; i++) {
            reversed[i] = elements[count - i - 1];
        }
        elements = reversed;
    }

    /**
     * We need to check if we have reached end of our array expand it by 50%.
     * We have to create a new Array and copy all elements in it and return it.
     */
    private void resizeArrayIfRequired() {
        if (count == elements.length) {
            int[] newArray = new int[count * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    public String toString() {
        return Arrays.toString(elements);
    }
}
