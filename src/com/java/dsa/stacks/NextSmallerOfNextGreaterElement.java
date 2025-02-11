package com.java.dsa.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerOfNextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {5, 1, 9, 2, 5, 1, 7};
        nextSmallerOfNextGreaterNaive(arr, 7);
        nextSmallerOfNextGreaterOptimal(arr);
    }
    static void nextSmallerOfNextGreaterNaive(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int temp = arr[i];
            int next = -1;
            int ans = -1;
            for (int j=i+1; j<n; j++) {
                if (arr[j] > temp) {
                    next = j;
                    break;
                }
            }
            if (next == -1) {
                result.add(-1);
            } else {
                for (int j=next+1; j<n; j++) {
                    if (arr[j] < arr[next]) {
                        ans = j;
                        break;
                    }
                }
                if(ans == -1) {
                    result.add(-1);
                }
                else {
                    result.add(arr[ans]);
                }
            }
        }
        for(int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static void nextSmallerOfNextGreaterOptimal(int[] arr) {
        int NG[] = new int[arr.length];
        int RS[] = new int[arr.length];
        nextGreater(arr, NG, 'G');
        nextGreater(arr, RS, 'S');
        for (int i=0; i<arr.length; i++) {
            if (NG[i] != -1 && RS[NG[i]] != -1)
                System.out.print(arr[RS[NG[i]]]+" ");
            else
                System.out.print("-1 ");
        }
    }
    static void nextGreater(int[] arr, int[] next, char order) {
        /*
        Step1:
            - Create an empty stack (S) in which we store the indexes and NG[] that is user to store the indices
                of NGE of every element
        Step2:
            - Traverse the array in reverse order where i goes from n-1 to 0
            - While S is not empty and the top element of S is smaller than or equal to 'arr[i]' pop S
            - If S is empty, arr[i] has no greater element NG[i] = -1
            - else we have next greater element NG[i] = s.top()
            - push current element index in stack
        Step3:
            - Create an array RS[] used to store the index of the right smallest element
            - We repeat step 1&2 with little bit of modification
            - we use RS[] in place of NG[]
            - We pop element from stack S while S is not empty or the top element of S is greater than or equal
                to arr[i]
        Step4:
            - Compute all RSE of NGE
                where i goes from 0 to n-1
                if NG[i] != -1 && RS[NG[i]] != -1 print RS[NG[i]] else print -1
         */
        Stack<Integer> stack = new Stack<>();
        for (int i=arr.length-1; i>=0; i--) {
            // Traverse all array elements in reverse order
            // order == 'G' we compute next greater elements of every element
            // order == 'S' we compute right smaller element of every element
            while (!stack.isEmpty() && ((order == 'G') ? arr[stack.peek()] <= arr[i] : arr[stack.peek()] >= arr[i])) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                next[i] = stack.peek();
            } else {
                next[i] = -1;
            }
            stack.push(i);
        }
    }
}
