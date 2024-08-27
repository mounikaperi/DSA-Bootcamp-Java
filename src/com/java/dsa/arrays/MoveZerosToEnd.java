import java.util.Arrays;
public class MoveZerosToEnd {
	public static void main(String[] args) {
		int[] arr = {1, 2, 0, 0, 2, 3};
		int[] result = moveZerosToEnd(arr);
		System.out.println("Array after moving zeros to end: " + Arrays.toString(result));
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
}
