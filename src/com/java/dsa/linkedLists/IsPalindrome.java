import java.util.Stack;
public class IsPalindrome {
	public static void main(String[] args) {
		Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
		System.out.print("Original Linked List: ");
        printLinkedList(head);
        if (isPalindrome(head)) {
            System.out.println("BruteForce: The linked list is a palindrome.");
            // return;
        }
        if (isPalindromeOptimalApproach(head)) {
            System.out.println("Optimal: The linked list is a palindrome.");
            return;
        }
        System.out.println("The linked list is not a palindrome.");
	}
	private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
	private static boolean isPalindrome(Node head) {
	    Stack<Integer> stack = new Stack<>();
	    Node temp = head;
	    while (temp!=null) {
	        stack.push(temp.data);
	        temp = temp.next;
	    }
	    temp = head;
	    while (temp!=null) {
	        if (temp.data != stack.peek()) return false;
	        stack.pop();
	        temp = temp.next;
	    }
	    return true;
	}
	private static Node reverseLinkedList(Node head) {
	    if (head == null || head.next == null) return head;
	    Node newHead = reverseLinkedList(head.next);
	    Node front = head.next;
	    front.next = head;
	    head.next = null;
	    return newHead;
	}
	private static boolean isPalindromeOptimalApproach(Node head) {
	    if (head == null || head.next == null) return true;
	    Node slow = head;
	    Node fast = head;
	    while (fast!=null && fast.next!=null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    Node newHead = reverseLinkedList(slow.next);
	    Node first = head;
	    Node second = newHead;
	    while (second != null) {
	        if (first.data != second.data) {
	            reverseLinkedList(newHead); // set to original list
	            return false;
	        }
	        first = first.next;
	        second = second.next;
	    }
	    reverseLinkedList(newHead);
	    return true;
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
        this.next = null;
    }
}
