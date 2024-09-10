public class FindMiddleNode {
	public static void main(String[] args) {
		// https://leetcode.com/problems/middle-of-the-linked-list/description/
	    Node head = new Node(1);
	    head.next = new Node(2);
	    head.next.next = new Node(3);
	    head.next.next.next = new Node(4);
	    head.next.next.next.next = new Node(5);
	    Node middleNode = findMiddle(head);
	    System.out.println("The middle node value is: " + middleNode.data);
	}
	static Node findMiddle(Node head) {
	    Node slow = head;
	    Node fast = head;
	    while (fast != null && fast.next != null && slow != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    return slow;
	}
}
class Node {
    int data;
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this.data = data;
    }
}
