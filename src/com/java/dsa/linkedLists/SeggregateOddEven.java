package com.java.dsa.linkedLists;

public class SeggregateOddEven {
	public static void main(String[] args) {
	    Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		System.out.println("Intial LinkedList : ");
        printLinkedList(head);
        Node newhead = seggregateToOddEven(head);
        System.out.println("LinkedList After Segregration ");
        printLinkedList(newhead);
	}
	private static Node seggregateToOddEven(Node head) {
	    if (head == null || head.next == null || head.next.next == null) return head;
	    Node odd = head;
	    Node even = head.next;
	    Node temp = head.next;
	    while (even != null && even.next!=null) {
	        odd.next = even.next;
	        odd = odd.next;
	        even.next = odd.next;
	        even = even.next;
	    }
	    odd.next = temp;
	    return head;
	}
	private static void printLinkedList(Node head) {
	    Node temp = head;
	    while (temp != null) {
	        System.out.print(temp.data + "-> ");
	        temp = temp.next;
	    }
	    System.out.println("END");
	}
}