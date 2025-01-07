package com.java.dsa.linkedLists;

public class CustomLinkedListImplementation {
	public static void main(String[] args) {
	    CustomLinkedList linkedList = new CustomLinkedList();
	    linkedList.insertAtStart(1);
	    linkedList.insertAtStart(2);
	    linkedList.insertAtStart(3);
	    linkedList.insertAtStart(4);
	    linkedList.insertAtStart(5);
	    linkedList.insertAtEnd(6);
	    linkedList.insertAtMiddle(2, 7);
	    linkedList.display();
	    System.out.println("The value that is deleted is: " + linkedList.deleteAtStart());
	    linkedList.display();
	    System.out.println("The value that is deleted is: " + linkedList.deleteAtEnd());
	    linkedList.display();
	    System.out.println("The value that is deleted is: " + linkedList.deleteAtIndex(3));
	    linkedList.display();
        linkedList.insertUsingRecursion(2, 2);
	    linkedList.display();
	}
}
class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public CustomLinkedList() {
        this.size = 0;
    }
    public void insertAtStart(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    public void insertAtEnd(int value) {
        if (tail == null) {
            insertAtStart(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insertAtMiddle(int index, int value) {
        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size) {
            insertAtEnd(value);
            return;
        }
        Node temp = head;
        for (int i=1; i<index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }
    public void insertUsingRecursion(int index, int value) {
        head = insertUsingRecursion(value, index, head);
    }
    private Node insertUsingRecursion(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertUsingRecursion(value, index--, node.next);
        return node;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public int deleteAtStart() {
        int value = head.value;
        if (tail == head) tail = tail.next;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }
    public int deleteAtEnd() {
        if (size <= 1) return deleteAtStart();
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;
    }
    public int deleteAtIndex(int index) {
        if (index == 0) deleteAtStart();
        if (index == size-1) deleteAtEnd();
        Node prev = get(index-1);
        int value = prev.next.value;
        prev.next = prev.next.next;
        prev.next = null;
        return value;
    }
    public Node find(int value) {
        Node node = head;
        while(node != null) {
            if (node.value == value) return node;
            node = node.next;
        }
        return node;
    }
    public Node get(int index) {
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    private class Node {
        private int value;
        private Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(int value) {
            this.value = value;
        }
    }
}
