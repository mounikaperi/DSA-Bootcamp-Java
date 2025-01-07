package com.java.dsa.linkedLists;

public class MergeTwoSortedLinkedLists {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/merge-two-sorted-lists/description/
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);

		Node head2 = new Node(6);
		head2.next = new Node(7);
		head2.next.next = new Node(8);
		head2.next.next.next = new Node(9);
		head2.next.next.next.next = new Node(10);
		Node result = mergeTwoLists(head1, head2);
		while (result != null) {
		    System.out.print(result.data + "->");
		    result = result.next;
		}
		System.out.println();
	}
	private static Node mergeTwoLists(Node head1, Node head2) {
		Node dummyNode = new Node(-1);
		Node newHead = dummyNode;
	    while (head1 != null && head2 != null) {
	        if (head1.data <= head2.data) {
	            newHead.next = head1;
	            head1 = head1.next;
	        } else {
	            newHead.next = head2;
	            head2 = head2.next;
	        }
	        newHead = newHead.next;
	    }
	    // add remaining elements 
	    newHead.next = (head1 == null) ? head2 : head1;
	    return dummyNode.next;
	}
}