package com.java.dsa.binarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
      // https://leetcode.com/problems/koko-eating-bananas/description/
      int[] piles = {3,6,7,11};
      int h = 8;
      int minimumTime = minEatingSpeed(piles, h);
      System.out.println("Minimum number of hours needed for koko to eat all bananas: " + minimumTime);
    }
    private static int minEatingSpeed(int[] piles, int h) {
      int low = 1;
      int high = findMax(piles);
      int ans = 0;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        int totalHours = calculateNoOfHours(piles, mid);
        if (totalHours <= h) {
          ans = mid;
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      return ans;
    }
    private static int calculateNoOfHours(int[] piles, int h) {
      int totalHours = 0;
      for (int num: piles) {
        totalHours += Math.ceil((double)(num) / (double)h);
      }
      return totalHours;
    }
    private static int findMax(int[] piles) {
      int max = Integer.MIN_VALUE;
      for (int num: piles) {
        max = Math.max(num, max);
      }
      return max;
    }
}
