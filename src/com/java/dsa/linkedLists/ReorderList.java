package com.java.dsa.linkedLists;

public class ReorderList {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/reorder-list/
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		System.out.print("Original Linked List: ");
        printLinkedList(head);
        System.out.print("Reorderd Linked List: ");
        reorderList(head);
        printLinkedList(head);
	}
	private static void printLinkedList(Node head) {
        Node temp = head;
	    while (temp!=null) {
	        System.out.print(temp.data+" ");
	        temp = temp.next;
	    }
	    System.out.println();
	}
	private static void reorderList(Node head) {
        if (head == null || head.next == null) return; 
        Node middleNode = getMiddleNode(head);
        Node headSecond = reverseLinkedList(middleNode);
        Node headFirst = head;
        // rearrange
        while (headFirst != null && headSecond != null) {
            Node temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }
        if (headFirst != null) headFirst.next = null;
    }
    private static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;
	    while(temp!=null) {
            Node front = temp.next; // store the next node in front to preserve the reference
	        temp.next = prev;
	        prev = temp;
	        temp = front;
	    }
	    return prev;
    }
}