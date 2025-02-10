package com.java.dsa.stacks;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ImplementStackUsingPriorityQueue {
    public static void main(String[] args) {
        PriorityStack s = new PriorityStack();
        s.push(3);
        s.push(2);
        s.push(1);
        while (!s.isEmpty()) {
            System.out.println(s.top());
            s.pop();
        }
    }
}
class PriorityStack {
    int count;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
    public PriorityStack() {
        count = 0;
    }
    void push(int n) {
        count++;
        pq.offer(new int[] { count, n});
    }
    void pop() {
        if (pq.isEmpty()) {
            System.out.println("Nothing to pop!!!");
            return;
        }
        count--;
        pq.poll();
    }
    int top() {
        int[] temp = pq.peek();
        return temp[1];
    }
    boolean isEmpty() {
        return pq.isEmpty();
    }
    public static void main(String[] args) {
        PriorityStack s = new PriorityStack();
        s.push(3);
        s.push(2);
        s.push(1);
        while (!s.isEmpty()) {
            System.out.println(s.top());
            s.pop();
        }
    }
}
