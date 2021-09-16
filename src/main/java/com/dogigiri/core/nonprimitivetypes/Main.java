package com.dogigiri.core.nonprimitivetypes;

public class Main {
    public static void main(String[] args) {
        String str1 = "test";
        String str2 = new String("test2");

        char[] arr = new char[2];
        arr[0] = 'd';
        arr[1] = 'e';

        for(char c: arr) System.out.print(c);
        System.out.println(str1);
        System.out.println(str2);
    }
}
