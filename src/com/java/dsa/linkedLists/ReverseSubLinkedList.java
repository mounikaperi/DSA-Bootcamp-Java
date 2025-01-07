package com.java.dsa.linkedLists;

public class ReverseSubLinkedList {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/reverse-linked-list-ii/
        Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		System.out.print("Original Linked List: ");
        printLinkedList(head);
        System.out.print("Reversed Sub Linked List: ");
        reverseBetween(head, 2, 4);
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
	private static Node reverseBetween(Node head, int left, int right) {
        // if there is only one node or no need to reverse return the original list
        if (head == null || head.next == null || left == right) return head;
        // dummynode to simplify the handling of head node
        Node dummyNode = new Node(0, head);
        // pointer to track the node before the reversal
        Node nodeBeforeReverse = dummyNode;
        for (int i=0; i<left-1; i++) {
            nodeBeforeReverse = nodeBeforeReverse.next;
        }
        // firstreversed will become last node after reversal
        Node firstReversed = nodeBeforeReverse.next;
        Node current = firstReversed;
        Node prev = null;
        for (int i=0; i<right-left+1; i++) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        // Reconnect the reversed section back to the list
        nodeBeforeReverse.next = prev;
        firstReversed.next = current;
        return dummyNode.next;
    }
}