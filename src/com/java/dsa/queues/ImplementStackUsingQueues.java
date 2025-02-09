package com.java.dsa.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    /*
    Given a Queue data structure that supports standard operations like enqueue() and dequeue().
    The task is to implement a Stack data structure using Queue.
    */
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}
class Stack {
    Deque<Integer> mainQueue = new ArrayDeque<>();
    Deque<Integer> auxQueue = new ArrayDeque<>();
    public Stack() {
        // No initialization needed as Java Deque is initialized by default
    }
    public void push(int x) {
        auxQueue.offer(x);
        while (!mainQueue.isEmpty()) {
            auxQueue.offer(mainQueue.poll());
        }
        Deque<Integer> temp = mainQueue;
        mainQueue = auxQueue;
        auxQueue = temp;
    }
    public int pop() {
        return mainQueue.poll();
    }
    public int top() {
        return mainQueue.peek();
    }
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
