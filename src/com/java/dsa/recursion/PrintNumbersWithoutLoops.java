package com.java.dsa.recursion;

public class PrintNumbersWithoutLoops {
    public static void main(String[] args) {
        printNumbers(10);
        System.out.println();
        printNumbersReverse(10);
    }
    static void printNumbers(int n) {
        if (n > 0) {
            printNumbers(n-1);
            System.out.print(n + " ");
        }
        return;
    }
    static void printNumbersReverse(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            printNumbersReverse(n-1);
        }
        return;
    }
}
