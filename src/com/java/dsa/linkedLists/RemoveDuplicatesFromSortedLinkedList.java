package com.java.dsa.linkedLists;

public class RemoveDuplicatesFromSortedLinkedList {
	public static void main(String[] args) {
        // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
        Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(3);
        Node result = deleteDuplicates(head);
		while (result != null) {
		    System.out.print(result.data + "->");
		    result = result.next;
		}
		System.out.println("END");
	}
	private static Node deleteDuplicates(Node head) {
        Node temp = head;
        while (temp!=null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}