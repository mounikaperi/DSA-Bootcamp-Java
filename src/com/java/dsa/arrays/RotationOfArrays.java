import java.util.Arrays;
public class RotationOfArrays {
	public static void main(String[] args) {
	    int[] arr1 = {10, 20, 30, 40, 50}; int k=3;
	    leftRotateArrayByOne(arr1);
	    System.out.println("Array after left rotated by one: " + Arrays.toString(arr1));
	    int[] arr2 = {10, 20, 30, 40, 50};
	    leftRotateArrayByK(arr2, k);
	    System.out.println("Array after left rotated by k: " + Arrays.toString(arr2));
	    int[] arr3 = {10, 20, 30, 40, 50}; 
	    leftRotateArrayByKUsingRecursion(arr3, k);
	    System.out.println("Array after left rotated by k: " + Arrays.toString(arr3));
	    int[] arr4 = {10, 20, 30, 40, 50}; 
	    rightRotateArrayByK(arr4, k);
	    System.out.println("Array after left rotated by k: " + Arrays.toString(arr4));
	    int[] arr5 = {10, 20, 30, 40, 50}; 
	    rightRotateArrayByKUsingRecursion(arr5, k);
	    System.out.println("Array after left rotated by k: " + Arrays.toString(arr5));
	    
	}
	private static void leftRotateArrayByOne(int[] arr) {
	    int temp = arr[0];
	    for (int i=0; i<arr.length-1; i++) {
	        arr[i] = arr[i+1];
	    }
	    arr[arr.length-1] = temp;
	}
	private static void reverseArray(int[] arr, int start, int end) {
	    while (start <= end) {
	        int temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    }
	}
	private static void leftRotateArrayByK(int[] arr, int k) {
	    int n = arr.length;
	    if (n==0) return;
	    k = k%n;
	    if (k>n) return;
	    int[] temp = new int[k];
	    for (int i=0; i<k; i++) temp[i] = arr[i];
	    for (int i=0; i<n-k; i++) arr[i] = arr[i+k];
	    for (int i=n-k; i<n; i++) arr[i] = temp[i-n+k];
	}
	private static void leftRotateArrayByKUsingRecursion(int[] arr, int k) {
	    int n = arr.length;
	    reverseArray(arr, 0, k-1); // Reverse first k elements - 30 20 10
	    reverseArray(arr, k, n-1); // reverse last n-k elements - 50 40
	    reverseArray(arr, 0, n-1); // reverse whole array - 40 50 30 20 10
	}
	private static void rightRotateArrayByK(int[] arr, int k) {
	    int n = arr.length;
	    if (n==0) return;
	    k = k%n;
	    if (k > n) return;
	    int[] temp = new int[k];
	    for (int i=n-k; i<n; i++) temp[i-n+k] = arr[i];
	    for (int i=n-k-1; i>=0; i--) arr[i+k] = arr[i];
	    for (int i=0; i<k; i++) arr[i] = temp[i];
	}
	private static void rightRotateArrayByKUsingRecursion(int[] arr, int k) {
	    int n = arr.length;
	    reverseArray(arr, 0, n-k-1); // Reverse first n-k elements 20 10
	    reverseArray(arr, n-k, n-1); // reverse last k elements 50 40 30
	    reverseArray(arr, 0, n-1); // reverse whole array 30 40 50 20 10
	}
}
