package com.java.dsa.binarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
      // https://leetcode.com/problems/koko-eating-bananas/description/
      int[] piles = {3,6,7,11};
      int h = 8;
      int minimumTime = maxEatingSpeedNaive(piles, h);
      System.out.println("Minimum number of hours needed for koko to eat all bananas: " + minimumTime);
      int minimumTime1 = minEatingSpeed(piles, h);
      System.out.println("Minimum number of hours needed for koko to eat all bananas: " + minimumTime1);
    }
    static int maxEatingSpeedNaive(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        for (int speed=1; speed<=max; speed++) {
            int time = 0;
            for (int bananas: piles) {
                time += bananas / speed; // time required to eat this pile of bananas at current speed
                if (bananas % speed != 0) // 1 extra hour to eat this remainder number of bananas in this pile
                    time++;
            }
            if (time <=h) return speed;
        }
        return max;
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
