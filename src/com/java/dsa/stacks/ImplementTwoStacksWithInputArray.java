package com.java.dsa.stacks;

public class ImplementTwoStacksWithInputArray {
    public static void main(String[] args)
    {
        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is "
                + ": " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is "
                + ": " + ts.pop2());

        TwoStacksOptimal ts1= new TwoStacksOptimal(5);
        ts1.push1(5);
        ts1.push2(10);
        ts1.push2(15);
        ts1.push1(11);
        ts1.push2(7);
        System.out.println("Popped element from"
                + " stack1 is " + ts1.pop1());
        ts1.push2(40);
        System.out.println("Popped element from"
                + " stack2 is " + ts1.pop2());
    }
}
// The Idea is to implement two stacks is to divide the array into two halves
// and assign two halves to two stacks arr[0]...arr[n/2] and arr[n/2+1]...arr[n-1]
// for stack2 where arr[] is the array to be used to implement two stacks and
// size of array be n
class TwoStacks {
    int[] arr;
    int size;
    int top1, top2;
    TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = n/2+1;
        top2 = n/2;
    }
    void push1(int x) {
        if (top1 > 0) {
            top1--;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow by element : " + x);
            return;
        }
    }
    void push2(int x) {
        if (top2 < size-1) {
            top2++;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow by element : " + x);
            return;
        }
    }
    int pop1() {
        if (top1 <= size/2) {
            int x = arr[top1];
            top1++;
            return x;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 0;
    }
    int pop2() {
        if (top2 >= size/2+1) {
            int x = arr[top2];
            top2--;
            return x;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 1;
    }
}

// The problem in the above implementation is that as we reserve half of the array
// for a stack and another half for another stack. So let if first half is full
// means first stack already have n/2 elements and second half is not full means
// it doesnt have n/2 elements. So, if we look into the array, there are free spaces
// inside array(eg. in the next half) but we cannot push elements for stack 1
// (because first half is reserved for stack 1 and it’s already full). It means
// this implementation show stack overflow although the array is not full.
// The solution for this answer is the below implementation.


// Follow the steps below to solve the problem:
//
// Stack1 starts from the leftmost corner of the array, the first element in stack1 is pushed at index 0 of the array.
// Stack2 starts from the rightmost corner of the array, the first element in stack2 is pushed at index (n-1) of the array.
// Both stacks grow (or shrink) in opposite directions.
// To check for overflow, all we need to check is for availability of space between top elements of both stacks.
// To check for underflow, all we need to check is if the value of the top of the both stacks  is between 0 to (n-1) or not.
class TwoStacksOptimal {
    int size;
    int top1, top2;
    int[] arr;
    TwoStacksOptimal(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }
    void push1(int x) {
        if (top1 < top2-1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }
    void push2(int x) {
        if (top1 < top2-1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }
    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }
    int pop2()
    {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }
}