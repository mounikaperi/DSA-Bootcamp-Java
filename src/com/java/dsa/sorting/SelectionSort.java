import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {10, 8, 9, 6, 7, 5, 4, 3, 1, 2};
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("Array after sorting: " + Arrays.toString(arr));
	}
	private static void selectionSort(int[] arr) {
	    for (int i=0; i<arr.length; i++) {
	        // Find the maximum element in the remaining array and swap with correct index
	        int last = arr.length - i - 1;
	        int maxIndex = getMaxIndex(arr, 0, last);
	        swap(arr, maxIndex, last);
	    }
	}
	private static int getMaxIndex(int[] arr, int start, int end) {
	    int max = start;
	    for (int i=start; i<=end; i++) {
	        if (arr[i] > arr[max]) max = i;
	    }
	    return max;
	}
	private static void swap(int[] arr, int first, int second) {
	    int temp = arr[first];
	    arr[first] = arr[second];
	    arr[second] = temp;
	}
}
