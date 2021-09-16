package com.dogigiri.core.functionalprogramming.lambda;

public class VacuumCleaner implements Cleaner {
    @Override
    public void clean(String s) {
        System.out.println(s + " has a good efficiency");
    }
}
