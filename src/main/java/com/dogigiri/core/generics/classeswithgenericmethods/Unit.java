package com.dogigiri.core.generics.classeswithgenericmethods;

import java.util.List;

public class Unit {
    public static <T extends List<Number>> void show(T list){
        System.out.println(list.get(0));
    }
}
