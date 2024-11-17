public class BinarySearch {
    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      System.out.println("The element is found at: " + binarySearchRecursive(arr, 0, arr.length-1, 10));
    }
    private static void binarySearchRecursive(int[] arr, int low, int high, int target) {
      int mid = (low + high) / 2;
      if (arr[mid] == target) return mid;
      else if (target > arr[mid]) return binarySearchRecursive(arr, mid+1, high, target);
      return binarySearchRecursive(arr, low, mid-1, target);
    }
}