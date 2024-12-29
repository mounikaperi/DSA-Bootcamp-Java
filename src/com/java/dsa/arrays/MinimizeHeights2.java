import java.util.*;

public class MinimizeHeights2 {
    public static void main(String[] args) {
      // https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/minimize-the-heights3351
      // negative numbers should not be considered
      int[] arr = {1, 5, 8, 10};
      int k = 2;
      System.out.println("The minimum difference between max tower and min tower is: " + getMinDiff(k, arr));
    }
    private static int getMinDiff(int k, int[] arr) {
      int n = arr.length;
      Arrays.sort(arr);
      int result = arr[n-1] - arr[0];
      for (int i=1; i<n; i++) {
        if (arr[i] - k < 0) continue;
        int minimumHeight = Math.min(arr[0] + k, arr[i] - k);
        int maximumHeight = Math.max(arr[i-1] + k, arr[n-1] - k);
        result = Math.min(maximumHeight - minimumHeight, result);
      }
      return result;
    }
}