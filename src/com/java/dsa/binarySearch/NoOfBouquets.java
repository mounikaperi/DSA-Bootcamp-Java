import java.util.*;

public class NoOfBouquets {
    public static void main(String[] args) {
        // https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
      int[] bloomDay = {1,10,3,10,2};
      int m = 3, k = 1;
      int minimumTime = minDays(bloomDay, m , k);
      System.out.println("Number of min days to form bouquets: " + minimumTime);
    }
    private static int minDays(int[] bloomDay, int m, int k) {
      long val = (long) m * k;
      if (val > bloomDay.length) return -1;
      int low = Integer.MAX_VALUE;
      int high = Integer.MIN_VALUE;
      for (int num: bloomDay) {
        low = Math.min(num, low);
        high = Math.max(num, high);
      }
      while(low <= high) {
        int mid = low + (high - low) / 2;
        if (possibleToBloom(bloomDay, mid, m, k)) high = mid - 1;
        else low = mid + 1;
      }
      return low;
    }
    private static boolean possibleToBloom(int[] arr, int day, int m, int k) {
      int count = 0;
      int noOfBouqets = 0;
      for (int num: arr) {
        if (num <= day) count++;
        else {
          noOfBouqets += count / k;
          count = 0;
        }
      }
      noOfBouqets += count / k;
      return noOfBouqets >= m;
    }
}
