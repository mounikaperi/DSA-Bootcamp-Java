import java.util.*;

public class CountSubArraySumEqualsK {
  public static void main(String[] args) {
    int[] arr = {3, 1, 2, 4};
    int k = 6;
    int cnt = findAllSubarraysWithGivenSum(arr, k);
    cnt = findAllSubarraysBetterApproach(arr, k);
    cnt = findAllSubarraysOptimal(arr, k);
    System.out.println("The number of subarrays is: " + cnt);
  }
  private static int findAllSubarraysWithGivenSum(int[] arr, int target) {
    int n = arr.length;
    int count = 0;
    for (int i=0; i<n; i++) {
      for (int j=i; j<n; j++) {
        int sum = 0;
        for (int k=i; k<=j; k++) {
          sum += arr[k];
        }
        if (sum == target) count++;
      }
    }
    return count;
  }
  private static int findAllSubarraysBetterApproach(int[] arr, int target) {
    int n = arr.length;
    int count = 0;
    for (int i=0; i<n; i++) {
      int sum = 0;
      for (int j=i; j<n; j++) {
        sum += arr[j];
        if (sum == target) count++;
      }
    }
    return count;
  }
  private static int findAllSubarraysOptimal(int[] arr, int target) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, count = 0;
    map.put(0, 1);
    for (int i=0; i<n; i++) {
      sum += arr[i];
      int remove = sum - target;
      count += map.getOrDefault(remove, 0);
      map.put(sum, map.getOrDefault(sum , 0) + 1);
    }
    return count;
  }
}