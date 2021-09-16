package com.dogigiri.core.collections.iterator;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {
    private T[] list = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        list[count++] = item;
    }

    public T get(int index) {
        return list[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {
        private GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.list[index++];
        }
    }

}
