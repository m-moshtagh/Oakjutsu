package com.dogigiri.datastructures.linear.linkedlist.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple implementation of Linked List data structure only working with
 * Integer data type.
 *
 * @author dogigiri
 * @version 1.0
 * @since 2021
 */
public class MyLinkedList {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyLinkedList.class);

    private Node head;
    private Node tail;
    private int size;

    /**
     * Method to add a new Node to the first chain of our Linked list.
     *
     * @param element an integer value to be stored in a node on our Linked list.
     */
    public void addFirst(int element) {
        var node = new Node(element);
        if (isEmpty()) head = tail = node;
        else {
            node.nextNode = head;
            head = node;
        }
        size++;
    }

    /**
     * method to add new element in a new node on the tail of the Linked list.
     *
     * @param element an integer value to be stored in a node on our Linked list.
     */
    public void addLast(int element) {
        var node = new Node(element);
        if (isEmpty()) head = tail = node;
        else {
            tail.nextNode = node;
            tail = node;
        }
        size++;
    }

    /**
     * returns index of an element if exists.
     *
     * @param element The element the user wants to find the index of.
     * @return returns The index of the element we want to find. returns -1 if it doesn't exist.
     */
    public int indexOf(int element) {
        if (isEmpty()) throw new IllegalStateException();
        int index = 0;
        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.element == element) return index;
            currentNode = currentNode.nextNode;
            index++;
        }
        return -1;
    }

    /**
     * This method removes the first node from the linked list
     */
    public void removeFirst() {
        if (isEmpty()) throw new IllegalStateException();
        if (size == 1) head = tail = null;
        else {
            var secondNode = head.nextNode;
            head.nextNode = null;
            head = secondNode;
        }
        size--;
    }

    /**
     * This method removes the last node from the linked list
     */
    public void removeLast() {
        if (isEmpty()) throw new IllegalStateException();
        if (size == 1) head = tail = null;
        else {
            tail = findPrevious(tail);
            assert tail != null : "There is a problem finding the previous node of tail";
            tail.nextNode = null;
        }
        size--;
    }

    /**
     * This method checks if the linked list is empty or not
     *
     * @return true if the linked list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * This method checks if an element exists in linked list
     *
     * @param element the element we are looking for in linked list
     * @return true if the element exists in linked list
     */
    public boolean contains(int element) {
        return (indexOf(element) != -1);
    }

    /**
     * returns the size of the linked list
     *
     * @return size of the linked list instance
     */
    public int size() {
        return size;
    }

    /**
     * reverse linked list
     */
    public void reverse() {
        if (isEmpty()) throw new IllegalStateException();
        var previous = head;
        var current = head.nextNode;
        while (current != null) {
            var next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        tail = head;
        tail.nextNode = null;
        head = previous;
    }

    /**
     * Cast linked list to an Array
     *
     * @return array which is equivalent to linked list
     */
    public int[] toArray() {
        if (isEmpty()) throw new IllegalStateException();
        var array = new int[size];
        var currentNode = head;
        int index = 0;
        while (currentNode != null) {
            array[index++] = currentNode.element;
            currentNode = currentNode.nextNode;
        }
        return array;
    }

    /**
     * This method returns the kth number element from the end.
     * @param k index number from the end
     * @return kth element from the end
     */
    public int getKthFromTheEnd(int k) {
        /*
            We need to check if the linked list is empty or not.
            also, we need to check if the k is bigger than the size or not.
         */
        if(isEmpty() || k > size) throw new IllegalStateException();
        /*
            We take two pointers with k - 1 distance from each other so if the second one reaches the tail, we
            will find the kth node. for example: we are looking for the 3rd node from the end in the list below
            => the answer will be 15.
            [1]  [5]  [10]  [15]  [20]  [25]
            *           *
            The last result after loop is:
            [1]  [5]  [10]  [15]  [20]  [25]
                             *            *
         */
        var firstPointer = head;
        var secondPointer = head;
//        *: we need to loop through list to place the second pointer on the correct place.
        for (var i = 0; i < k - 1; i++)
            secondPointer = secondPointer.nextNode;
        while (secondPointer != tail) {
            firstPointer = firstPointer.nextNode;
            secondPointer = secondPointer.nextNode;
        }
        return firstPointer.element;
    }

    /**
     * A method to print the middle node of a linked list. This method is focused to be implemented without knowing the
     * size of the linked list.
     * it gets tricky when the number of nodes is even, so we need to return two elements.
     * [1] -> [2] -> [3] -> [4] -> [5] =============>   the middle node will be ( 3 )
     * [1] -> [2] -> [3] -> [4] -> [5] -> [6] ->[7] -> [8] -> [9] -> [10]  =============> the middle will be ( 5 & 6)
     */
    public void printMiddle() {
        var a = head;
        var b = head;
        while (b != tail && b.nextNode != tail) {
            b = b.nextNode.nextNode;
            a = a.nextNode;
        }
        if(b == tail) LOGGER.info("The middle is {}", a.element);
        else {
            assert a != null;
            LOGGER.info("The middle elements are: {} & {}", a.element, a.nextNode.element);
        }
    }

    /**
     * this method checks if we have any loop in our list for example if the last node links back to another middle nodes
     * we use two pointers which move with different pace and if they face each other in their way to end we'll have a
     * loop
     * @return true if we have a loop in our linked list
     */
    public boolean hasLoop() {
        var firstPointer = head;
        var secondPointer = head;
        while (secondPointer != null && secondPointer.nextNode != null) {
            firstPointer = firstPointer.nextNode;
            secondPointer = secondPointer.nextNode.nextNode;

            if (firstPointer.equals(secondPointer))
                return true;
        }
        return false;
    }

    /**
     * iterates over linked list to find the previous node of a specific node
     *
     * @param node The node that we want to find its previous node
     * @return the node previous to the input node
     */
    private Node findPrevious(Node node) {
        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.nextNode == node) return currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    /**
     * Internal node class which we chain to build the linked list
     */
    private static class Node {
        private final int element;
        private Node nextNode;

        public Node(int value) {
            this.element = value;
        }
    }
}
