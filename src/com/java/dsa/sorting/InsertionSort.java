import java.util.Arrays;
public class Main {
	public static void InsertionSort(String[] args) {
		int[] arr = {10, 8, 9, 6, 7, 5, 4, 3, 1, 2};
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("Array after sorting: " + Arrays.toString(arr));
	}
	private static void insertionSort(int[] arr) {
	    for (int i=0; i<arr.length-1; i++) {
	        for (int j=i+1; j>0; j--) {
	            if (arr[j] < arr[j-1]) {
	                swap(arr, j, j-1);
	            } else {
	                break;
	            }
	        }
	    }
	}
	private static void swap(int[] arr, int first, int second) {
	    int temp = arr[first];
	    arr[first] = arr[second];
	    arr[second] = temp;
	}
}
