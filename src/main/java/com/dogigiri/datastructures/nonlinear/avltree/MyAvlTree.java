package com.dogigiri.datastructures.nonlinear.avltree;

public class MyAvlTree {
    private Node root;

    public void insert(int value) {
        root = insert(this.root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);
        } else {
            node.leftChild = insert(node.leftChild, value);
        }
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        if (isLeftHeavy(node)) System.out.println(node.value + " is Left heavy");
        if (isRightHeavy(node)) System.out.println(node.value + " is Right heavy");
        return node;
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private class Node {
        private final int value;
        private int height;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + value + '}';
        }
    }
}
