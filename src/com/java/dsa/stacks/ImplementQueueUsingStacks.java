package com.java.dsa.stacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    // We are given a stack data structure with push and pop operations, the task is to implement a queue using instances of stack data structure and operations on them.
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
class Queue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    void enqueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    int dequeue() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.pop();
    }
}