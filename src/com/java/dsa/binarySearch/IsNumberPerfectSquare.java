package com.java.dsa.binarySearch;

public class IsNumberPerfectSquare {
    public static void main(String[] args) {
        // https://leetcode.com/problems/valid-perfect-square/
        int num = 16;
        System.out.println("Is the number " +num+ " a perfect square? " + isPerfectSquare(num));
    }
    private static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) (mid * mid) == num) return true;
            else if ((long) (mid*mid) < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}

