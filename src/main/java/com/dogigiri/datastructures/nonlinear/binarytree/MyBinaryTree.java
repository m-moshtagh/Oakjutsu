package com.dogigiri.datastructures.nonlinear.binarytree;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {
    private Node root;

    public int insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return root.value;
        }
        var currentNode = root;
        while (true) {
            if (value > currentNode.value) {
                if (currentNode.rightChildren == null) {
                    currentNode.rightChildren = newNode;
                    return currentNode.rightChildren.value;
                }
                currentNode = currentNode.rightChildren;
            } else {
                if (currentNode.leftChildren == null) {
                    currentNode.leftChildren = newNode;
                    return currentNode.leftChildren.value;
                }
                currentNode = currentNode.leftChildren;
            }
        }
    }

    public boolean find(int value) {
        if (root == null) throw new IllegalStateException();
        var currentNode = root;
        while (true) {
            if (value > currentNode.value) {
                currentNode = currentNode.rightChildren;
            } else if (value < currentNode.value) {
                currentNode = currentNode.leftChildren;
            } else {
                return true;
            }
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseMidOrder() {
        traverseMidOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            getNodesAtDistance(i).forEach(value -> LoggerFactory.getLogger(MyBinaryTree.class).info("{}", value));
        }
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        LoggerFactory.getLogger(MyBinaryTree.class).info("{}", root.value);
        traversePreOrder(root.leftChildren);
        traversePreOrder(root.rightChildren);
    }

    private void traverseMidOrder(Node root) {
        if (root == null) return;
        traversePreOrder(root.leftChildren);
        LoggerFactory.getLogger(MyBinaryTree.class).info("{}", root.value);
        traversePreOrder(root.rightChildren);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePreOrder(root.leftChildren);
        traversePreOrder(root.rightChildren);
        LoggerFactory.getLogger(MyBinaryTree.class).info("{}", root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) return 0;
        return 1 + Math.max(height(root.leftChildren), height(root.rightChildren));
    }
    // O(log n)
    public int min() {
        if(root == null) throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChildren;
        }
        return last.value;
    }

    // O(n)
    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }
        var left = min(root.leftChildren);
        var right = min(root.rightChildren);
        return Math.min(Math.min(left, right), root.value);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if(root == null) return true;
        if(root.value < min || root.value > max) return false;
        return isBinarySearchTree(root.leftChildren, min, root.value - 1)
                && isBinarySearchTree(root.rightChildren, root.value + 1, max);
    }

    public boolean equals(MyBinaryTree otherTree) {
        if(otherTree == null) return false;
        return equals(root, otherTree.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null) return true;
        if(first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChildren, second.leftChildren)
                    && equals(first.rightChildren, second.rightChildren);

        return false;
    }

    public List<Integer> getNodesAtDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, List<Integer> list) {
        if (root == null) {
            return;
        }
        if(distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChildren, distance - 1, list);
        getNodesAtDistance(root.rightChildren, distance - 1, list);
    }

    private boolean isLeaf(Node node) {
        return node.leftChildren == null && node.rightChildren == null;
    }
    private class Node {
        private final int value;
        private Node leftChildren;
        private Node rightChildren;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + value + '}';
        }
    }
}
