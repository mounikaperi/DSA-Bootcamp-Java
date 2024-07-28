package com.java.dsa.bitmanipulation;

public class SwapTwoNumbersWithoutThird {
    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println("Values of a and b before swap: " + a + " " + b);
        int[] swappedArray = swap(a, b);
        System.out.println("Values of a and b after swap: " + swappedArray[0] + " " + swappedArray[1]);
    }
    static int[] swap(int a, int b) {
        // even number of 1's - 0, odd number of 1's - 1, s ^ s = 0, s ^ 0 = s
        a = a ^ b;
        b = a ^ b; // a ^ b ^ b = a
        a = a ^ b; // a ^ b ^ a = b
        return new int[] {a, b};
    }
}
