import java.util.HashMap;
public class StartingPointInLoop {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.next = node2;
		Node node3 = new Node(3);
		node2.next = node3;
		Node node4 = new Node(4);
		node3.next = node4;
		Node node5 = new Node(5);
		node4.next = node5;
		node5.next = node2;
		Node head = node1;
		Node loopStartNode = detectLoop(head);
		Node loopStartNode1 = detectLoopUsingTortoiseHareAlgo(head);
		if (loopStartNode!=null) {
		    System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
		  //  return;
		}
		if (loopStartNode1!=null) {
		    System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
		    return;
		}
		System.out.println("No loop detected in the linkedList");
	}
	private static Node detectLoop(Node head) {
	    Node temp = head;
	    HashMap<Node, Integer> nodeMap = new HashMap<>();
	    while(temp!=null) {
	        if (nodeMap.containsKey(temp)) return temp;
	        nodeMap.put(temp, 1);
	        temp = temp.next;
	    }
	    return null;
	}
	private static Node detectLoopUsingTortoiseHareAlgo(Node head) {
	    Node tortoise = head;
	    Node hare = head;
	    while (hare!=null && hare.next!=null) {
	        tortoise = tortoise.next;
	        hare = hare.next.next;
	        if (tortoise==hare) {
	            tortoise = head;
	            while(tortoise!=hare) {
	                tortoise = tortoise.next;
	                hare = hare.next;
	            }
	            return tortoise;
	        }
	    }
	    return null;
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
