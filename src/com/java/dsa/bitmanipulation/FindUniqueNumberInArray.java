package com.java.dsa.bitmanipulation;

public class FindUniqueNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 3, 2, 1, 6};
        System.out.println(findNumber(arr));
    }
    static int findNumber(int[] arr) {
        int unique = 0;
        for (int n: arr) unique ^= n;
        return unique;
    }
}
