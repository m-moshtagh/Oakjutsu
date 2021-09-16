package com.dogigiri.datastructures.nonlinear.tries;

import java.util.HashMap;
import java.util.Map;

public class MyTrie {
    private Node root = new Node(' ');
    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
            if (current.children.get(ch) == null) {
                current.children.put(ch, new Node(ch));
            }
            current = current.children.get(ch);
        }
    }
    private class Node {
        private char value;
        private Map<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
}
