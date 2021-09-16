package com.dogigiri.datastructures.nonlinear.tries;

public class MyTrieArray {
    private static final int ALPHABET = 26;
    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
            var index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node(ch);
            }
            current = current.children[index];
        }
        current.isEndOFWord = true;
    }

    private class Node {
        private char value;
        private Node[] children = new Node[ALPHABET];
        private boolean isEndOFWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
}
