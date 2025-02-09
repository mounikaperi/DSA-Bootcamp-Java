package com.java.dsa.stacks;

public class ImplementDynamicStack {
    public static void main(String[] args) {
        // Creating a stack
        DynamicStack st = new DynamicStack();
        // Push elements onto the stack
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        // Print top element of the stack
        System.out.println("Top element is " + st.peek());
        // removing two elemements from the top
        System.out.println("Removing two elements...");
        st.pop();
        st.pop();
        // Print top element of the stack
        System.out.println("Top element is " + st.peek());
    }
}
class DynamicStack {
    Node head;
    DynamicStack() {
        this.head = null;
    }
    boolean isEmpty() {
        return head == null;
    }
    void push(int newData) {
        Node newNode = new Node(newData);
        if (newNode == null) {
            System.out.println("Stack Overflow");
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        Node temp = head;
        head = head.next;
        temp = null;
    }
    int peek() {
        if (!isEmpty()) {
            return head.data;
        }
        System.out.println("Stack is empty");
        return Integer.MIN_VALUE;
    }
}
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
