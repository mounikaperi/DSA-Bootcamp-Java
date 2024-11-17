import java.util.*;

public class MaxRepeatedNumber {
    public static void main(String[] args) {
      // Given an array of n numbers, find the element, which appears maximum number of times
      int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 1, 2};
      System.out.println("Maximum repeated element in array is: " + getMax1(arr, 10));
      System.out.println("Maximum repeated element in array is: " + getMax2(arr, 10));
      System.out.println("Maximum repeated element in array is: " + getMax3(arr, 10));
    }
    /**
     * First approach: Exhaustive search or Brute force, for each element in array 
     * find how many times this particular value appears in array. Keep track of 
     * the maxCount and when some element count is greater than it then update 
     * the maxCount. This is done using two for loop, first loop to select the 
     * element and second loop to count the occurrence of that element.
    */
    private static int getMax1(int[] arr, int size) {
      int max = arr[0];
      int count = 1;
      int maxCount = 1;
      for (int i=0; i<size; i++) {
        count = 1;
        for (int j=i+1;j<size; j++) {
          if (arr[i] == arr[j]) count++;
          if (count > maxCount) {
            max = arr[i];
            maxCount = count;
          }
        }
      }
      return max;
    }
    /**
     * Second approach: Sorting, Sort all the elements in the array and after 
     * this in a single scan, we can find the counts. Sorting algorithms take
     * time and single scan take time.
    */
    private static int getMax2(int[] arr, int size) {
      int max = arr[0];
      int maxCount = 1;
      int curr = arr[0];
      int currCount = 1;
      Arrays.sort(arr);
      for (int i=1; i<size; i++) {
        if (arr[i] == arr[i-1]) currCount++;
        else {
          currCount = 1;
          curr = arr[i];
        }
        if (currCount > maxCount) {
          maxCount = currCount;
          max = curr;
        }
      }
      return max;
    }
    /**
     * Third approach: Counting, This approach is only possible if we know the 
     * range of the input. If we know that, the elements in the array are in the
     * range 0 to n-1. We can reserve and array of length n and when we see an 
     * element we can increase its count. In just one single scan, we know the 
     * duplicates. If we know the range of the elements, then this is the 
     * fastest way to find the max count.
    */ 
    private static int getMax3(int[] arr, int size) {
      int max = arr[0];
      int maxCount = 1;
      int[] count = new int[size];
      for (int i=0; i<size; i++) {
        count[arr[i]]++;
        if (count[arr[i]] > maxCount) {
          maxCount = count[arr[i]];
          max = arr[i];
        }
      }
      return max;
    }
}