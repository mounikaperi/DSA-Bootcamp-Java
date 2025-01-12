package com.java.dsa.sorting;

import java.util.*;

public class MergeOverlappingIntervals {
  public static void main(String[] args) {
    int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
    List<List<Integer>> ans = mergeOverlappingIntervalsBruteForce(arr);
    for (List<Integer> it : ans) {
      System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
    }
    System.out.println();
    ans = mergeOverlappingIntervalsOptimalApproach(arr);
    System.out.print("The merged intervals are: \n");
    for (List<Integer> it : ans) {
      System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
    }
    System.out.println();
    int[][] arr1 = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};

    // Get the new size of the array after merging
    int newSize = mergeOverlapUsingInPlace(arr1);

    // Print the merged intervals based on the new size
    for (int i = 0; i < newSize; i++) {
      System.out.println(arr1[i][0] + " " + arr1[i][1]);
    }
  }
  private static List<List<Integer>> mergeOverlappingIntervalsBruteForce(int[][] arr) {
    int n = arr.length;
    Arrays.sort(arr, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    List<List<Integer>> ans = new ArrayList<>();
    for (int i=0; i<n; i++) {
      int start = arr[i][0];
      int end = arr[i][1];
      if (!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1))
        continue;
      for (int j=i+1; j<n; j++) {
        if (arr[j][0] <= end) 
          end = Math.max(end, arr[j][1]);
        else
          break;
      }
      ans.add(Arrays.asList(start, end));
    }
    return ans;
  }
  private static List<List<Integer>> mergeOverlappingIntervalsOptimalApproach(int[][] arr) {
    int n = arr.length;
    Arrays.sort(arr, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0]-b[0];
      }
    });
    List<List<Integer>> ans = new ArrayList<>();
    for (int i=0; i<n; i++) {
      if (ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)) 
        ans.add(Arrays.asList(arr[i][0], arr[i][1]));
      else
        ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
    }
    return ans;
  }
  static List<int[]> mergeOverlap(int[][] arr) {
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> result = new ArrayList<>();
    result.add(new int[] {arr[0][0], arr[0][1]});
    for (int i=1; i<arr.length; i++) {
      int[] last = result.get(result.size()-1);
      int[] curr = arr[i];
      if (curr[0] <= last[1]) last[1] = Math.max(last[1], curr[1]);
      else result.add(new int[] {curr[0], curr[1]});
    }
    return result;
  }
  static int mergeOverlapUsingInPlace(int[][] arr) {
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    int resIndex = 0;
    for (int i=1; i<arr.length; i++) {
      // If the currentInterval is not the first interval and it overlaps with the previous interval
      // then merge it with previous interval. If the currentInterval does not overlap with previous interval move to next
      if (arr[resIndex][1] >= arr[i][0])
        arr[resIndex][1] = Math.max(arr[resIndex][1], arr[i][1]);
      else {
        resIndex++;
        arr[resIndex] = arr[i];
      }
    }
    return resIndex+1;
  }
}