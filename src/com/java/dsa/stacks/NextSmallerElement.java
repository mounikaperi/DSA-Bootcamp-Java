package com.java.dsa.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nextSmallerElement(arr);
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
