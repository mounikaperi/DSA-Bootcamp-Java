import java.util.Arrays;
import java.util.ArrayList;
public class Sort0s1s2s {
	public static void main(String[] args) {
		int n = 6;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0,2,1,2,0,1}));
		System.out.println("Before sorting:");
		for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
		sortArray(arr, n);
		System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
	}
	private static void sortArray(ArrayList<Integer> arr, int n) {
	    int low = 0; 
	    int high = n-1;
	    int mid = 0;
	    while (mid <= high) {
	        if (arr.get(mid) == 0) {
	            swap(arr, low, mid);
	            low++;
	            mid++;
	        } else if (arr.get(mid)==1){
	            mid++;
	        } else {
	            swap(arr, mid, high);
	            high--;
	        }
	    }
	}
	private static void swap(ArrayList<Integer> arr, int start, int end) {
	    int temp = arr.get(start);
	    arr.set(start, arr.get(end));
	    arr.set(end, temp);
	}
}
