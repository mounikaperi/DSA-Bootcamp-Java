import java.util.*;

public class MinimizeHeights1 {
    public static void main(String[] args) {
      // https://www.geeksforgeeks.org/problems/minimize-the-heights-i/1
      int[] arr = {3, 9, 12, 16, 20};
      int k = 3;
      System.out.println("The minimum difference between max tower and min tower is: " + getMinDiff(k, arr));
    }
    private static int getMinDiff(int k, int[] arr) {
      int n = arr.length;
      Arrays.sort(arr);
      int result = arr[n-1] - arr[0];
      for (int i=1; i<n; i++) {
        int minimumHeight = Math.min(arr[0] + k, arr[i] - k);
        int maximumHeight = Math.max(arr[i-1] + k, arr[n-1] - k);
        result = Math.min(maximumHeight - minimumHeight, result);
      }
      return result;
    }
}