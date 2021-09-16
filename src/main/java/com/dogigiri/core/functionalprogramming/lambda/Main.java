package com.dogigiri.core.functionalprogramming.lambda;

public class Main {
    public static void main(String[] args) {
        clean(new VacuumCleaner());
        clean(new Cleaner() {
            @Override
            public void clean(String s) {
                System.out.println("human have less efficiency");
            }
        });

        clean(s -> System.out.println(s + " has good efficiency"));
    }
    public static void clean(Cleaner cleaner) {
        cleaner.clean("Vacuum ");
    }
}
