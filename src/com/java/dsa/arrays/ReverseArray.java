import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
      // Article: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/article/MjU2Nw%3D%3D
      int[] arr = {1, 4, 3, 2, 6, 5};
      System.out.println("Reverse array using temporary array: " + Arrays.toString(reverseArrayUsingTempArray(arr)));
      System.out.println("Reverse array using 2 pointers: " + Arrays.toString(reverseArrayUsingTwoPointers(arr)));
      System.out.println("Reverse array using swap: " + Arrays.toString(reverseArrayUsingSwap(arr)));
      reverseArrayUsingRecursion(arr, 0, arr.length-1);
      System.out.println("Reverse array using recursion: " + Arrays.toString(arr));
    }
    private static int[] reverseArrayUsingTempArray(int[] arr) {
      int n = arr.length;
      int[] temp = new int[n];
      int count = 0;
      for (int i=n-1; i>=0; --i) {
        temp[count] = arr[i];
        count++;
      }
      return temp;
    }
    private static int[] reverseArrayUsingTwoPointers(int[] arr) {
      int left = 0; int right = arr.length-1;
      while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }
      return arr;
    }
    private static int[] reverseArrayUsingSwap(int[] arr) {
      int n = arr.length;
      for (int i=0; i<n/2; i++) {
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
      }
      return arr;
    }
    private static void reverseArrayUsingRecursion(int[] arr, int start, int end) {
      if (start >= end) return;
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      reverseArrayUsingRecursion(arr,start+1, end-1);
    }
}