import java.util.*;

public class SecondLargestElementInArray {
    // Article: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/article/MTQ4NDk1
    public static void main(String[] args) {
      int[] arr = {12, 35, 1, 10, 34, 1};
      System.out.println(getSecondLargestViaNaiveApproach(arr));
      System.out.println(getSecondLargestViaTwoPassSearch(arr));
      System.out.println(getSecondLargestViaOnePass(arr));
    }
    private static int getSecondLargestViaNaiveApproach(int[] arr) {
      Arrays.sort(arr);
      for (int i=arr.length-2; i>=0; i--) {
        if (arr[i] != arr[arr.length-1]) 
          return arr[i];
      }
      return -1;
    }
    private static int getSecondLargestViaTwoPassSearch(int[] arr) {
      int n = arr.length;
      int largest = -1, secondLargest = -1;
      for (int i = 0; i < n; i++) {
        if (arr[i] > largest)
          largest = arr[i];
      }
      for (int i = 0; i < n; i++) {
        if (arr[i] > secondLargest && arr[i] != largest) {
          secondLargest = arr[i];
        }
      }
      return secondLargest;
    }
    private static int getSecondLargestViaOnePass(int[] arr) {
      int n = arr.length;
      int largest = -1, secondLargest = -1;
      for (int i = 0; i < n; i++) {
        if(arr[i] > largest) {
          secondLargest = largest;
          largest = arr[i];
        } else if(arr[i] < largest && arr[i] > secondLargest) {
          secondLargest = arr[i];
        }
      }
      return secondLargest;
    }
}