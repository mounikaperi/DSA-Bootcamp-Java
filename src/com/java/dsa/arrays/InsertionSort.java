import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
      System.out.println("Before sort:");
      char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
      System.out.println(Arrays.toString(arr));
      insertionSort(arr);
      System.out.println("After sort:");
      System.out.println(Arrays.toString(arr));
    }
/**
 * Insertion Sort:
 * The algorithm proceeds by considering one element at a time, placing the element
 * in correct order relative to those before it. We start with the first element
 * in array which is trivially sorted by itself. When considering the next element
 * in array, if it is smaller than the first we swap them. Next, when we consider
 * the third element in array, swapping it leftward until it is proper order relative
 * to the first two elements.We note that if an array is already sorted, the inner loop of insertion-sort does
 * only one comparison, determines that there is no swap needed, and returns back
 * to the outer loop.
 */
 
 // Insertion-sort of an array of characters into nondecreasing order
 private static void insertionSort(char[] arr) {
   int n = arr.length;
   for (int k = 1; k < n; k++) {
    char curr = arr[k];
    int j = k;
    while (j > 0 && arr[j-1] > curr) {
      arr[j] = arr[j-1];
      j--;
    }
    arr[j] = curr;
   }
 }
}