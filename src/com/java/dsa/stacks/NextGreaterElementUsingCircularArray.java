package com.java.dsa.stacks;

import java.util.Stack;
public class NextGreaterElementUsingCircularArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int[] result = nextGreaterElement(arr);
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=2*n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }
            if (i < n) {
                result[i] = stack.isEmpty() ? -1: stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return result;
    }
}
