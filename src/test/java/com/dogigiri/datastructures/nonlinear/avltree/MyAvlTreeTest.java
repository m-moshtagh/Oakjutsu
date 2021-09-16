package com.dogigiri.datastructures.nonlinear.avltree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyAvlTreeTest {
    MyAvlTree tree;
    @BeforeEach
    void setUp() {
        tree = new MyAvlTree();
        tree.insert(5);
    }

    @Test
    void insert() {
        tree.insert(10);
        tree.insert(4);
        tree.insert(22);
    }
}