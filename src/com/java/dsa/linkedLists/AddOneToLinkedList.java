public class AddOneToLinkedList {
	public static void main(String[] args) {
		Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);
        System.out.print("Original Linked List: ");
        printLinkedList(head);
        head = addOne(head);
        System.out.print("LinkedList after adding one: ");
        printLinkedList(head);
	}
	private static Node addOne(Node head) {
	    Node reversedList = reverseList(head);
	    Node temp = reversedList;
	    int carry = 1;
	    while (temp!=null) {
	        int sum = temp.data + carry;
	        carry = sum / 10;
	        temp.data = sum % 10;
	        if (carry == 0) break;
	        if (temp.next == null && carry > 0) {
	            temp.next = new Node(carry);
	            carry = 0;
	        }
	        temp = temp.next;
	    }
	    return reverseList(reversedList);
	}
	private static Node reverseList(Node head) {
	    Node currentNode = head;
	    Node prevNode = null;
	    while (currentNode!=null) {
	        Node nextNode = currentNode.next;
	        currentNode.next = prevNode;
	        prevNode = currentNode;
	        currentNode = nextNode;
	    }
	    return prevNode;
	}
	private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        }
        System.out.println();
    }
}
class Node {
    int data;
    Node next;
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }
    Node(int data1) {
        data = data1;
        next = null;
    }
}
