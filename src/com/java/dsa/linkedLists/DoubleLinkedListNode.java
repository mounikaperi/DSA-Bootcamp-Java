package com.java.dsa.linkedLists;

class DoubleLinkedListNode {
    // Data stored in the node
    int data;
    // Pointer to the next node in the list
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;

    // Constructor with both data
    // and next node as parameters
    DoubleLinkedListNode(int data, DoubleLinkedListNode prev, DoubleLinkedListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    DoubleLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}