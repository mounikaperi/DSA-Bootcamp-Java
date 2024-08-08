import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		bubbleSort(arr);
	}
	private static void bubbleSort(int[] arr) {
	    boolean swapped = false;
	    int[] inputArr = new int[arr.length];
	    for (int i=0; i<arr.length; i++) inputArr[i] = arr[i];
	    for (int i=0; i<arr.length; i++) {
	        swapped = false;
	        for (int j=1; j<arr.length-i; j++) {
	            if (arr[j] < arr[j-1]) {
	                int temp = arr[j];
	                arr[j] = arr[j-1];
	                arr[j-1] = temp;
	                swapped = true;
	            }
	        }
	        if (!swapped) {
	            break;
	        }
	    }
	    if (Arrays.equals(inputArr, arr)) System.out.println("The given input array is already sorted");
	    else System.out.println("The array is not already sorted...Array after sorting: " + Arrays.toString(arr));
	}
}
