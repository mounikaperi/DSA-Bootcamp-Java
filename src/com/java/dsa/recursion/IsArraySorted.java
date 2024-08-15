public class IsArraySorted {
	public static void main(String[] args) {
	    int[] arr = {10, 1, 9, 2, 3, 8, 7, 4, 6, 5};
	    boolean isArraySorted = sorted(arr, 0);
		System.out.println("Is Array sorted: " + sorted(arr, 0));
	}
	private static boolean sorted(int[] arr, int index) {
	    if (index == arr.length-1) return true;
	    return arr[index] < arr[index + 1] && sorted(arr, index+1);
	}
}
