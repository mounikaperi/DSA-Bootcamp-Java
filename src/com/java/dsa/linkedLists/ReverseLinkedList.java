package com.java.dsa.linkedLists;

import java.util.Stack;
public class ReverseLinkedList {
	// https://leetcode.com/problems/reverse-linked-list/description/
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		System.out.print("Original Linked List: ");
        printLinkedList(head);
        head = reverseLinkedListUsingBruteForce(head);
        System.out.print("Reversed Linked List using BruteForce: ");
        printLinkedList(head);
        head = reverseLinkedListUsingOptimal(head);
        System.out.print("Reversed Linked List using optimal approach: ");
        printLinkedList(head);
        head = reverseLinkedListUsingRecursion(head);
        System.out.print("Reversed Linked List using Recursive approach: ");
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
	private static Node reverseLinkedListUsingBruteForce(Node head) {
	    Node temp = head;
	    Stack<Integer> stack = new Stack<>();
	    while (temp!=null) {
	        stack.push(temp.data);
	        temp = temp.next;
	    }
	    temp = head;
	    while (temp!=null) {
	        temp.data = stack.pop();
	        temp = temp.next;
	    }
	    return head;
	}
	private static Node reverseLinkedListUsingOptimal(Node head) {
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
	private static Node reverseLinkedListUsingRecursion(Node head) {
	    if (head == null || head.next == null) return head;
	    Node newHead = reverseLinkedListUsingRecursion(head.next);
	    Node front = head.next;
	    front.next = head;
	    head.next = null;
	    return newHead;
	}
}
