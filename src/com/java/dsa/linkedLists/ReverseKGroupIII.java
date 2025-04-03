package com.java.dsa.linkedLists;

class Node {
    int data;      
    Node next;     
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseKGroupIII {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        head = reverseKGroup(head, 4);

        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static int index = 0;
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		if (n == 1 && b[0] == 0) {
			return head;
		}
		if (head == null) {
			return null;
		}
		if (index >= n) {
			return head;
		}
		int i=0;
		while (index < n && b[index] == 0) {
			index++;
		}
		i = b[index];
		Node curr = head, prev = null, next = null;
		while (curr != null && i-- > 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		index++;
		head.next = getListAfterReverseOperation(curr, n, b);
		return prev;
	}
}