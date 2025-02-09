package com.java.dsa.stacks;

import java.util.Stack;

public class MinStack {
    // https://leetcode.com/problems/min-stack/
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<Pair>();
    }
    public void push(int val) {
        int min;
        if (stack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(stack.peek().min, val);
        }
        stack.push(new Pair(val, min));
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek().val;
    }
    public int getMin() {
        return stack.peek().min;
    }
}
class Pair {
    int val;
    int min;
    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
