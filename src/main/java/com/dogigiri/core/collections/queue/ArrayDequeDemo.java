package com.dogigiri.core.collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("b");
        queue.add("a");
        queue.add("c");
        System.out.println(queue);

        String peek = queue.peek();
        System.out.println(queue + " peek" + " element is " + peek);

        String poll = queue.poll();
        System.out.println(queue + " poll" + "element is " + poll);

        queue.offer("d");
        System.out.println(queue + " offer");

        queue.add("e");
        System.out.println(queue + " add");

        String element = queue.element();
        System.out.println(queue + " element " + "element is " + element);

        String remove = queue.remove();
        System.out.println(queue + " remove" + " element is " + remove);
    }
}
