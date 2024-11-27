import java.util.*;

public class SmallPositiveMissingNumber {
  public static void main(String[] args) {
    int[] arr = {2, -3, 4, 1, 1, 7};
    System.out.println(findMissingNumberUsingNaive(arr));
    System.out.println(findMissingNumberUsingBetter(arr));
    System.out.println(findMissingNumberUsingCycleSort(arr));
    System.out.println(findMissingNumberUsingNegatingElements(arr));
    int[] arr1 = {2, -3, 4, 1, 1, 7};
    System.out.println(findMissingNumberByMarkingIndices(arr1));
  }
  private static int findMissingNumberUsingNaive(int[] arr) {
    /**
     * The idea is to sort the array and assume the missing number as 1
     * Now iterate over the array and each element arr[i]
     * if (arr[i] == missingNumber) then increment missingNumber by 1
     * if (arr[i] < missingNumber) then continue to search for missingNumber
     * if (arr[i] > missingNumber) break and return the missingNumber
    */
    Arrays.sort(arr);
    int missingNumber = 1;
    for (int value: arr) {
      if (value == missingNumber) missingNumber++;
      else if (value > missingNumber) break;
    }
    return missingNumber;
  }
  private static int findMissingNumberUsingBetter(int[] arr) {
    /**
     * The idea is to create a visited array, to keep track of which numbers 
     * from the original array were present. For each positive number in the 
     * input array, we mark its corresponding position in the visited array. 
     * After that, we go through the visited array to find the first position 
     * that isn’t visited. The first unvisited index tells us the first missing 
     * positive number.Note that we are marking numbers within the range from 
     * 1 to n only.
     */ 
    int n = arr.length;
    boolean[] visited = new boolean[n];
    for (int i=0; i<n; i++) {
      if (arr[i] > 0 && arr[i] <= n) {
        visited[arr[i]-1] = true;
      }
    }
    // find the first element which is unvisited in the original array
    for (int i = 1; i <= n; i++) {
      if (!visited[i - 1]) return i;
    }
    // if all the elements from 1 to n are visited then n+1 will be first positive missing number
    return n+1;
  }
  private static int findMissingNumberUsingCycleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
        int temp = arr[i];
        arr[i] = arr[arr[i] - 1];
        arr[temp - 1] = temp;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (i != arr[i - 1]) {
        return i;
      }
    }
    return n + 1;
  }
  private static int findMissingNumberUsingNegatingElements(int[] arr) {
    int partition = getPartitionIndex(arr);
    for (int i=0; i<partition; i++) { // transition postive part of array
      int val = Math.abs(arr[i]); // Find the absolute value to get original number
      // if val is within range, then mark the element at index (val-1) to negative
      if (val-1 < partition && arr[val-1] > 0)
        arr[val-1] = -arr[val-1];
    }
      // Find first unmarked index
    for (int i=0; i<partition; i++) {
      if (arr[i] > 0) return i+1;
    }
    return partition+1;
  }
  private static int getPartitionIndex(int[] arr) {
    int partition = 0;
    int n = arr.length;
    for (int i=0; i<n; i++) {
      if (arr[i]>0) {
        int temp = arr[i];
        arr[i] = arr[partition];
        arr[partition] = temp;
        partition++;
      }
    }
    return partition;
  }
  private static int findMissingNumberByMarkingIndices(int[] arr) {
    int n = arr.length;
    boolean flag = false;
    // Check if 1 is present in array or not
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        flag = true;
        break;
      }
    }
    // If 1 is not present
    if (!flag) return 1;
    // Change out of range values to 1
    for (int i = 0; i < n; i++) {
      if (arr[i] <= 0 || arr[i] > n) arr[i] = 1;
    }
    // Mark the occurrence of numbers directly within the same array
    for (int i = 0; i < n; i++) {
      arr[(arr[i] - 1) % n] += n;
    }
    // Finding which index has value less than n
    for (int i = 0; i < n; i++) {
      if (arr[i] <= n)
        return i + 1;
    }
    // If array has values from 1 to n
    return n + 1;
  }
}
