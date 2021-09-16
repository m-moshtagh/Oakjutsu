package com.dogigiri.core.collections.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List list = new ArrayList<>(25);
        list.add(25);
        list.add(2);
        list.add(56);
        list.add(0, "1");
        list.forEach(System.out::println);

        System.out.println(list.indexOf(1)); // returns false because we added 1 as a string
        System.out.println(list.subList(0, 2));


    }

}
