import java.util.Map;
import java.util.HashMap;
public class DetectLoopInLinkedList {
	public static void main(String[] args) {
		// https://leetcode.com/problems/linked-list-cycle/description/
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = third;
		if (detectLoopUsingBruteForce(head)) {
		    System.out.println("Brute Force: Loop detected in the linked list");
		  //  return;
		}
		if (detectLoopUsingTortoiseHareAlgorithm(head)) {
		    System.out.println("TortoiseHareAlgorithm: Loop detected in the linked list");
		    return;
		}
		System.out.println("No loop detected in the linked list");
	}
	private static boolean detectLoopUsingBruteForce(Node head) {
	    Node temp = head;
	    Map<Node, Integer> nodeMap = new HashMap<>();
	    while (temp != null) {
	        if (nodeMap.containsKey(temp)) {
	            return true;
	        }
	        nodeMap.put(temp, 1);
	        temp = temp.next;
	    }
	    return false;
	}
	private static boolean detectLoopUsingTortoiseHareAlgorithm(Node head) {
	    Node tortoise = head;
	    Node hare = head;
	    while (hare!=null && hare.next!=null) {
	        hare = hare.next.next;
	        tortoise = tortoise.next;
	        if (tortoise == hare) {
	            return true;
	        }
	    }
	    return false;
	}
}
class Node {
    public int data;
    public Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(int data) {
        this.data = data;
    }
}
