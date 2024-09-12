import java.util.Map;
import java.util.HashMap;
public class LengthOfLoop {
	public static void main(String[] args) {
		// https://leetcode.com/problems/linked-list-cycle-ii/description/
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = second;
		int loopLength = lengthOfLoop(head);
		if (loopLength > 0) {
		    System.out.println("Length of the loop using BruteForce: " + loopLength);
		  //  return;
		}
		int loopLength1 = lengthOfLoopUsingTortoiseHareAlgo(head);
		if (loopLength1 > 0) {
		    System.out.println("Length of the loop using TortoiseHare Algorithm: " + loopLength1);
		    return;
		}
		System.out.println("No loop found in the linked list.");
	}
	private static int lengthOfLoop(Node head) {
	    Map<Node, Integer> visitedNodes = new HashMap<>();
	    Node temp = head;
	    int timer = 0;
	    while(temp!=null) {
	        if (visitedNodes.containsKey(temp)) {
	            int loopLength = timer - visitedNodes.get(temp);
	            return loopLength;
	        }
	        visitedNodes.put(temp, timer);
	        temp = temp.next;
	        timer++;
	    }
	    return 0;
	}
	private static int lengthOfLoopUsingTortoiseHareAlgo(Node head) {
	    Node tortoise = head;
	    Node hare = head;
	    while (hare != null && hare.next != null) {
	        tortoise = tortoise.next;
	        hare = hare.next.next;
	        if (tortoise == hare) {
	            int count = 1;
	            hare = hare.next;
	            while (hare!=tortoise) {
	                count++;
	                hare = hare.next;
	            }
	            return count;
	        }
	    }
	    return 0;
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
