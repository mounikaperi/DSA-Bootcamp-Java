package com.java.dsa.linkedLists;

public class SeggregateOddEvenValuedNodes {
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
	    if (head == null || head.next == null) {
            return head;
        }

        Node even = new Node(-1);
        Node evenTemp = even;

        Node odd = new Node(-1);
        Node oddTemp = odd;


        Node temp = head;
        while (temp != null) {
            if ((temp.data & 1) == 1) { // implies odd value
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            } else {
                evenTemp.next = temp;
                evenTemp = evenTemp.next;
            }
            temp = temp.next;
        }
        evenTemp.next = odd.next;
        oddTemp.next = null;
        return even.next;
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