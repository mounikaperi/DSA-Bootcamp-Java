package com.java.dsa.queues;

public class ArrayImplementationOfQueue {
    public static void main(String[] args) {
        // Create a queue with capacity 4
        Queue q = new Queue(4);
        // Display the empty queue
        q.display();
        // Insert elements
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        q.enqueue(60);
        q.display();
        // Delete elements
        q.dequeue();
        q.dequeue();
        System.out.println("After two node deletions:");
        q.display();
        // Get the front element
        q.getFront();
    }
}
class Queue {
    private int[] queue;
    private int front;
    private int size;
    private int capacity;
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.size = 0;
    }
    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        queue[front+size] = data;
        size++;
    }
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i=1; i<size; i++) {
            // Shift all elements to the left by one position
            queue[i-1] = queue[i];
        }
        size--;
    }
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " <- ");
        }
        System.out.println();
    }

    public void getFront() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front Element is: " + queue[front]);
        }
    }
}
