package com.java.dsa.linkedLists;

public class RotateLinkedList {
    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head = rotateOptimal(head, 6);
        printList(head);
        head = rotateOptimal(head, 6);
        printList(head);
    }
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    static Node rotate(Node head, int k) {
        if (k==0 || head == null) return head;
        for (int i=0; i<k; i++) {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = head;
            head = head.next;
            curr.next = null;
        }
        return head;
    }
    static Node rotateOptimal(Node head, int k) {
        /*
        1. Initialize curr to head of the linked list
        2. Traverse linkedlist using curr to find the length and stop curr at the end of linkedlist
        3. Since, k>=length, update k = k%n
        4. Make the linkedlist circular by updating next pointer of curr to head
        5. update curr to head and find kth node
        6. Traverse linkedlist till we reach the kth node
        7. update (k+1)th node as new head
        8. update kth node next to null
        */
        Node curr = head; int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        k = k % length;
        if (k == 0) return head;
        curr.next = head;
        curr = head;
        for (int i=1; i<k; i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
