package com.java.dsa.linkedLists;

public class RemoveNthNodeFromEnd {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);
        printLL(head);
        // Delete the Nth node from the end and print the modified linked list
        head = deleteNthNodefromEnd(head, N);
        printLL(head);
	}
	private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("END");
    }
    private static Node deleteNthNodefromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        // move the fast pointer n places
        for (int i=0; i<n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }
}
