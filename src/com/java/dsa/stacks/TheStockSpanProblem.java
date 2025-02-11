package com.java.dsa.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TheStockSpanProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 4, 5, 90, 120, 80));
        ArrayList<Integer> span = calculateSpan(arr);
        for (int x : span) {
            System.out.print(x + " ");
        }
        System.out.println();
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(10, 4, 5, 90, 120, 80));
        ArrayList<Integer> result = calculateSpanUsingStack(arr1);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
    static ArrayList<Integer> calculateSpan(ArrayList<Integer> arr) {
        // The idea is to traverse left in the array to compare prices and increment the span count
        // until a higher price is encountered or the start of the array is reached for each and every
        // day. This approach ensures that the span values are calculated based on the stock's performance
        // up to the given day
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            result.add(1);
        }
        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0 && arr.get(i) >= arr.get(j); j--) {
                result.set(i, result.get(i)+1);
            }
        }
        return result;
    }
    static ArrayList<Integer> calculateSpanUsingStack(ArrayList<Integer> arr) {
        // The idea is to use the stack to efficiently find the span of stock prices.
        // For each day, we remove indices from the stack while the current price >= the price of the top of the stack
        // If the stack becomes empty, it means all previous prices are smaller, and the span is the current day
        // index + 1. Otherwise, the span is the difference between the current index and top of the stack which
        // represents the last higher price's index.
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.set(i, (i+1));
            } else {
                result.set(i, (i - stack.peek()));
            }
            stack.push(i);
        }
        return result;
    }
}
