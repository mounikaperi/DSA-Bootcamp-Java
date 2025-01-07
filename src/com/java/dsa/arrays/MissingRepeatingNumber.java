package com.java.dsa.arrays;
public class MissingRepeatingNumber {
  public static void main(String[] args) {
    int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
    int[] ans = missingRepeatingNumberBruteForce(a);
    ans = missingRepeatingNumberHashing(a);
    System.out.println("The repeating and missing numbers are: {"+ ans[0] + ", " + ans[1] + "}");
  }
  private static int[] missingRepeatingNumberBruteForce(int[] arr) {
    int repeating = -1, missing = -1;
    for (int i=1; i<=arr.length; i++) {
      int count = 0;
      for (int j=0; j<arr.length; j++) {
        if (arr[j] == i) count++;
      }
      if (count == 2) repeating = i;
      else if (count == 0) missing = i;
      if (repeating != -1 && missing != -1) break;
    }
    int[] ans = {repeating, missing};
    return ans;
  }
  private static int[] missingRepeatingNumberHashing(int[] arr) {
    int n = arr.length;
    int[] hash = new int[n+1];
    for (int i=0; i<n; i++)
      hash[arr[i]]++;
    int repeating = -1, missing = -1;
    for (int i=1; i<=n; i++) {
      if (hash[i] == 2) repeating = i;
      else if (hash[i] == 0) missing = i;
      if (repeating != -1 && missing != -1) break;
    }
    return new int[] {repeating, missing};
  }
}