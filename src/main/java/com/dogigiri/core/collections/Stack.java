package com.dogigiri.core.collections;

public class Stack {
    public static void main(String[] args) {
        java.util.Stack<String> stack = new java.util.Stack();
        stack.push("Babak");
        stack.push("Hamid");
        stack.push("Roze");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
