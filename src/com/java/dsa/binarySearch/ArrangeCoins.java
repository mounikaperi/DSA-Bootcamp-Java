package com.java.dsa.binarySearch;
public class ArrangeCoins {
    public static void main(String[] args) {
        // https://leetcode.com/problems/arranging-coins/description/
        int num = 8;
        System.out.println("Number of Complete rows " + arrangeCoins(num));
    }
    private static int arrangeCoins(int num) {
        long low = 0;
        long high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long coinsUsed = mid * (mid + 1) / 2;
            if (coinsUsed == num) return (int) coinsUsed;
            else if (num > coinsUsed) low = mid + 1;
            else high = mid - 1;
        }
        return (int) high;
    }
}

