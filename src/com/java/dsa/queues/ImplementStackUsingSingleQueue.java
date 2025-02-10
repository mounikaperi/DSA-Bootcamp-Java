package com.java.dsa.queues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingSingleQueue {
    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.push(30);
        s.pop();
        System.out.println("Top element :" + s.top());
    }
}
class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    void push(int val) {
        int size = queue.size();
        queue.add(val);
        for (int i=0; i<size; i++) {
            int x = queue.remove();
            queue.add(x);
        }
    }
    int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.remove();
    }
    int top() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }
    boolean isEmpty() {
        return queue.isEmpty();
    }
}
