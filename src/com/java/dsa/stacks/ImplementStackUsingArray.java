package com.java.dsa.stacks;

class ImplementStackUsingArray {
    public static void main(String args[])
    {
        Stack s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}
class Stack<P> {
    static final int MAX = 1000;
    int top;
    int[] arr = new int[MAX];
    boolean isEmpty() {
        return (top < 0);
    }
    Stack() {
        top = -1;
    }
    boolean push(int x) {
        if (top >= MAX-1) {
            System.out.println("Stack Overflow");
            return false;
        }
        arr[++top] = x;
        System.out.println(x + " pushed into stack");
        return true;
    }
    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        int x = arr[top--];
        return x;
    }
    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return arr[top];
    }
    void print() {
        for (int i=top; i>-1; i--) {
            System.out.print(" " + arr[i]);
        }
    }
}
