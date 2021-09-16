package com.dogigiri.core.collections.list;

public class LinkedListDemo {
    public static void main(String[] args) {
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();

        list.add(5);
        list.add(4);
        list.add(0, 8);
        list.addFirst(1);
        list.addLast(65);
        list.add(78);
        System.out.println(list);
    }
}
