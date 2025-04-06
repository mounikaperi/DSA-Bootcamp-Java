package com.java.dsa.linkedLists;

public class DeleteAllOccurencesInDLL {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                if (temp == head) {
                    head = temp.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if (nextNode != null) nextNode.prev = prevNode;
                if (prevNode != null) prevNode.next = nextNode;
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}