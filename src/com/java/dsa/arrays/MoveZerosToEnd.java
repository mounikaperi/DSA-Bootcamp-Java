import java.util.Arrays;
public class MoveZerosToEnd {
	public static void main(String[] args) {
		// Article: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/article/MTIzNDkz
		int[] arr = {1, 2, 0, 0, 2, 3};
		int[] result = moveZerosToEnd(arr);
		System.out.println("Array after moving zeros to end: " + Arrays.toString(result));
	}
	private static void moveZerosToEndViaTempArr(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                temp[j++] = arr[i];
        }
        while (j < n)
            temp[j++] = 0;
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    
	}
	private static void pushZerosToEndViaTwoTraversals(int[] arr) {
        int count = 0;  
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }
        while (count < arr.length)
            arr[count++] = 0;
    }
	private static int[] moveZerosToEnd(int[] arr) {
	    int j = -1;
	    for (int i=0; i<arr.length; i++) {
	        if(arr[i] == 0) {
	            j = i;
	            break;
	        }
	    }
	    if (j==-1) return arr;
	    for (int i=j+1; i<arr.length; i++) {
	        if (arr[i] != 0) {
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            j++;
	        }
	    }
	    return arr;
	}
	private static void pushZerosToEndViaOneTraversal(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
    }
}
