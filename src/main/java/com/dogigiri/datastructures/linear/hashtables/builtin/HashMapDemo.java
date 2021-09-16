package com.dogigiri.datastructures.linear.hashtables.builtin;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> employeesMap = new HashMap<>();
        employeesMap.put(1, "Bob Builder");
        employeesMap.put(2, "Thomas Shelby");
        employeesMap.put(3, "Dean Winchester");
        employeesMap.put(4, "Uchiha Itachi");
        employeesMap.get(3);
        employeesMap.containsKey(7);
        employeesMap.containsValue("Uchiha");
        for (var item : employeesMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
