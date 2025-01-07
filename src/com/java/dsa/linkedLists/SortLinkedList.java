package com.java.dsa.linkedLists;

public class SortLinkedList {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);
        System.out.print("Original Linked List: ");
        printLinkedList(head);
        head = sortLL(head);
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
        head = sortListViaQuickSort(head);
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
    private static Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; 
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }   
    private static Node findMiddle(Node head){
        if (head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static Node sortLL(Node head){
        if (head == null || head.next == null) return head;
        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        left = sortLL(left);
        right = sortLL(right);
        return mergeTwoSortedLinkedLists(left, right);
    }
    private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        }
        System.out.println();
    }
    private static Node sortListViaQuickSort(Node head) {
        return quickSort(head, null);
    }
    private static Node quickSort(Node head, Node tail) {
        if (head == null || head.next == null || head == tail) return head;
        Node pivot = head;
        Node currentNode = head.next;
        Node prev = head;
        boolean sorted = true;
        while (currentNode!=null && currentNode!=tail) {
            Node nextNode = currentNode.next;
            if (pivot.data > currentNode.data) {
                sorted = false;
                currentNode.next = head;
                prev.next = nextNode;
                head = currentNode;
            } else {
                if (prev.data > currentNode.data) sorted = false;
                prev = currentNode;
            }
            currentNode = nextNode;
        }
        if (sorted) return head;
        pivot.next = quickSort(pivot.next, tail);
        return quickSort(head, pivot);
    }
}
