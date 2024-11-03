import java.util.*;

public class LargestSmallest {
    public static void main(String[] args) {
      int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9, 15, 10};
      System.out.println("The largest element is: " + findLargest(arr, arr.length));
      System.out.println("The second largest element is: " + findSecondLargest(arr));
      System.out.println("The smallest element is: " + findSmallest(arr, arr.length));
    }
    private static int findLargest(int[] arr, int length) {
      if (length == 1) return arr[0];
      return Math.max(arr[length-1], findLargest(arr, length-1));
    }
    private static int findSecondLargest(int[] arr) {
      int largest = -1; int secondLargest = -1;
      for (int i=0; i<arr.length; i++) {
        if (arr[i] > largest) {
          secondLargest = largest;
          largest = arr[i];
        }
        else if (arr[i] > secondLargest && arr[i] < largest) {
          secondLargest = arr[i];
        }
      }
      return secondLargest;
    }
    private static int findSmallest(int[] arr, int length) {
      if (length == 1) return arr[0];
      return Math.min(arr[length-1], findSmallest(arr, length-1));
    }
}