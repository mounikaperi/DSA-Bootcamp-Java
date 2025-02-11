package com.java.dsa.stacks;

import java.util.Stack;

public class TheCelebrityProblem {
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };
        int celebIdx = findCelebrityNaive(matrix, n);
        celebIdx = findCelebrityTwoPointers(matrix, n);
        celebIdx = findCelebrityUsingStack(matrix, n);
        if (celebIdx == -1)
            System.out.println("No Celebrity");
        else {
            System.out.println("Celebrity ID " + celebIdx);
        }
    }
    static int findCelebrityNaive(int[][] mat, int n) {
        int[] knowme = new int[n];
        int[] iknow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    knowme[j]++;
                    iknow[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (knowme[i] == n - 1 && iknow[i] == 0)
                return i;
        }
        return -1;
    }
    static int findCelebrityTwoPointers(int[][] matrix, int n) {
        int top = 0, down = n-1;
        while (top < down) {
            if (matrix[top][down] == 1) {// top knows down so it cannot be celebrity
                top++;
            } else if (matrix[down][top] == 1) {// down knows top so it cannot be celebrity
                down--;
            } else {// both top and down dont know each other both cannot be celebrity
                top++;
                down--;
            }
        }
        // i points to our celebrity candidate
        int candidate = top;

        // Now, all that is left is to check that whether
        // the candidate is actually a celebrity i.e: he is
        // known by everyone but he knows no one
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (matrix[i][candidate] == 0
                        || matrix[candidate][i] == 1)
                    return -1;
            }
        }
        // if we reach here this means that the candidate
        // is really a celebrity
        return candidate;
    }
    static int findCelebrityUsingStack(int[][] matrix, int n) {
        Stack<Integer> stack = new Stack<>();
        int celebrityId;
        for (int i=0; i<n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int celeb1 = stack.pop();
            int celeb2 = stack.pop();
            if (matrix[celeb1][celeb2] == 1) {
                stack.push(celeb2);
            } else {
                stack.push(celeb1);
            }
        }
        celebrityId = stack.pop();
        for (int i=0; i<n; i++) {
            if (i != celebrityId && (matrix[celebrityId][i] == 1 || matrix[i][celebrityId] == 0)) {
                return -1;
            }
        }
        return celebrityId;
    }
}
