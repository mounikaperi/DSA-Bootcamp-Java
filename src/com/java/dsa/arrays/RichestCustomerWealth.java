package com.java.dsa.arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3},
                {3, 1, 2}
        };
        System.out.println("Richest Wealth is :  " + calculateRichestWealth(arr));
    }
    static int calculateRichestWealth(int[][] accounts) {
        int max = accounts[0][0];
        for (int i=0; i<accounts.length; i++) {
            int sum =0;
            for (int j=0; j<accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
