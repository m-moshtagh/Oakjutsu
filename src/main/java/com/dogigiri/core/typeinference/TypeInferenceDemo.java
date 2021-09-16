package com.dogigiri.core.typeinference;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TypeInferenceDemo {
    public static void main(String[] args) {
        List<List<Set>> d = new ArrayList<>();
        var e = d;
        for (var a : e) {
            System.out.println(a);
        }
    }
}
