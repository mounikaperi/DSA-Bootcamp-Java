import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 4};
      System.out.println("The missing number is: " + findMissingNumber1(arr, 5));
      System.out.println("The missing number is: " + findMissingNumber2(arr, 5));
    }
    /**
     * First approach: Exhaustive search or Brute force, for each value in the 
     * range 1 to n, find if there is some element in array which have the same value.
     * This is done using two for loop, first loop to select value in the range 
     * 1 to n and the second loop to find if this element is in the array or not.
    */
    private static int findMissingNumber1(int[] arr, int size) {
      int found = 0;
      for (int i=1; i<=size; i++) {
        found = 0;
        for (int j=0; j<size; j++) {
          if (arr[j] == i) {
            found = 1;
            break;
          }
        }
        if (found == 0) return i;
      }
      return Integer.MAX_VALUE;
    }
    /**
     * Sorting, Sort all the elements in the array and after this in a single scan, 
     * we canfind the duplicates.
    */
    private static int findMissingNumber2(int[] arr, int size) {
      Arrays.sort(arr);
      for (int i=0; i<arr.length; i++) {
        if (arr[i] == arr[i+1])
          return arr[i]+1;
      }
      return Integer.MAX_VALUE;
    }
    /*
    Third approach: 
    Hash-Table, using Hash-Table, we can keep track of the elements we have already 
    seen and we can find the missing element in just one scan. Hash-Table insert and 
    find take constant time so the total Time Complexity of the algorithm is time. 
    
    Forth approach: Counting, we know the range of the input so counting will work. As we know
    that, the elements in the array are in the range 0 to n-1. We can reserve and array of length n and
    when we see an element we can increase its count. In just one single scan, we know the missing
    element.

    Fifth approach: You are allowed to modify the given input array. Modify the given input array in
    such a way that in the next scan you can find the missing element.
    When you scan through the array. When at index “index”, the value stored in the array will be
    arr[index] so add the number “n + 1” to arr[ arr[ index]]. Always read the value from the array
    using a reminder operator “%”. When you scan the array for the first time and modified all the
    values, then one single scan you can see if there is some value in the array which is smaller than
    “n+1” that index is the missing number.


    Sixth approach: Summation formula to find the sum of n numbers from 1 to n. Subtract the values
    stored in the array and you will have your missing number.


    Seventh approach: XOR approach to find the sum of n numbers from 1 to n. XOR the values
    stored in the array and you will have your missing number.

    */
}