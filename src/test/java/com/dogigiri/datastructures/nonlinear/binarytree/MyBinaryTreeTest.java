package com.dogigiri.datastructures.nonlinear.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBinaryTreeTest {
    MyBinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new MyBinaryTree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(5);
        tree.insert(22);
        tree.insert(9);
        tree.insert(18);
    }

    @Test
    void insert() {

        tree.insert(8);
        assertTrue(tree.find(8));
    }

    @Test
    void find() {
        assertTrue(tree.find(10));
    }

    @Test
    void traverseTest() {
        System.out.println("Pre-Order");
        tree.traversePreOrder();
        System.out.println("Mid-Order"); 
        tree.traverseMidOrder();
        System.out.println("Post-Order");
        tree.traversePostOrder();
        System.out.println("level-Order");
        tree.traverseLevelOrder();
    }

    @Test
    void heightTest() {
        int height = tree.height();
        assertEquals(3, height);
    }

    @Test
    void minTest() {
        assertEquals(5, tree.min());
    }

    @Test
    void equalsTest() {
        MyBinaryTree tree2 = new MyBinaryTree();
        tree2.insert(10);
        tree2.insert(12);
        tree2.insert(5);
        tree2.insert(22);
        tree2.insert(9);
        tree2.insert(18);
        tree2.insert(8);
        System.out.println(tree2.isBinarySearchTree());
        assertFalse(tree.equals(tree2));
    }

    @Test
    void isBinarySearchTreeTest() {
        assertTrue(tree.isBinarySearchTree());
    }

    @Test
    void getNodesAtDistanceTest() {
        assertEquals(18, tree.getNodesAtDistance(3).get(0));
    }
}