package com.java.dsa.linkedLists;

public class DeleteNodeWithoutLinkedListOrHead {
    public void deleteNode(Node node) {
        // We dont have the access to the linked list or the head of the linked list
        // all we have is the node that we have to delete
        // as we know the node that is to be deleted, we will copy the next node value to the node
        // which we want to delete and point the pointer to the other next element
        node.data = node.next.data;
        node.next = node.next.next;
    }
}

