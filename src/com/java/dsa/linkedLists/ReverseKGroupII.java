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

public class ReverseKGroupII {
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
    public Node reverseKGroup(Node head, int k) {
        // 1. Initialize a temporary node to traverse the list
        Node temp = head;
        // 2. Initialize the pointer to track the last node of the previous group
        Node prevLast = null;
        // 3. Traverse through the list
        while (temp != null) {
            // 4. Get the kthNode of the current Group
            Node kthNode = getKthNode(temp, k);
            // 5. If the kthNode is null then it is not complete group
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            // 6. Store the next node of the kthNode
            Node nextNode = kthNode.next;
            // 7. Disconnect the kthNode to prepare for reversal
            kthNode.next = null;
            // 8. Reverse the nodes from temp to kthNode
            reverseLinkedList(temp);
            // 9. Adjust the head if the reversal starts from the head;
            if (temp == head) {
                head = kthNode;
            } else {
                // 10. Link the last node of the previous group to the reversed group
                prevLast.next = kthNode;
            }
            // 11. Update the pointer to the last node of the previous group
            prevLast = temp;
            // 12. Move to the next group
            temp = nextNode;
        }
    }
    static Node getKthNode(Node temp, int k) {
        // Decrement the k as we already start from first node
        k = k-1;
        while (temp != null && k>0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }
}