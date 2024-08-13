import java.util.*;
public class SetMismatch {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/set-mismatch/description/
	    int[] arr = {1,2,2,4};
	    int[] result = setMismatch(arr);
	    System.out.println("The duplicate number is: " + result[0] + " and the missing number is: " + result[1]);
	}
	private static int[] setMismatch(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) swap(arr, i, correctIndex);
            else i++;
        }
        for (i = 0; i<arr.length; i++) {
            if (arr[i] - 1 != i) return new int[] {arr[i], i+1};
        }
        return new int[]{-1, -1};
    }
    private static void swap(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
