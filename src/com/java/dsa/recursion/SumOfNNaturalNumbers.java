package com.java.dsa.recursion;

public class SumOfNNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(recursionSum(10));
    }
    static int recursionSum(int n) {
        if (n <= 1) {
            return n;
        }
        return n + recursionSum(n-1);
    }
}
