package com.dogigiri.core.generics.wildcard;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        getListIndex(List.of(Integer.valueOf(123)));
    }

    public static void getListIndex(List<? extends Integer> input) {
        input.get(0);
        //input.add(Integer.valueOf(64646)); compiler error
    }

    public static void insertToList(List<? super Integer> input) {
        input.add(Integer.valueOf(49794));
        //input.(input.get(0)); compiler error
    }
}
