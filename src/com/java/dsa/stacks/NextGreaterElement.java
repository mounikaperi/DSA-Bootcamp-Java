package com.java.dsa.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        ArrayList<Integer> result = nextGreaterElementNaive(arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
        ArrayList<Integer> result1 = nextGreaterElement(arr);
        for (int x : result1) {
            System.out.print(x + " ");
        }
    }
    static ArrayList<Integer> nextGreaterElementNaive(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            result.add(-1);
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[j] > arr[i]) {
                    result.set(i, arr[j]);
                    break;
                }
            }
        }
        return result;
    }
    static ArrayList<Integer> nextGreaterElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            result.add(-1);
        }
        for (int i=n-1; i>=0; i--) {
            // Initialize the array from right to left
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
