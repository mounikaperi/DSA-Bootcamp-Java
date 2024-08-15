public class SearchTargetElement {
	public static void main(String[] args) {
	    int[] arr = {10, 1, 9, 2, 3, 8, 7, 4, 6, 5};
	    int target = 8;
	    boolean isTargetFound = findTarget(arr, target, 0);
		System.out.println("Is Target Found: " + isTargetFound);
	}
	private static boolean findTarget(int[] arr, int target, int index) {
	    if (index == arr.length) return false;
	    return arr[index] == target || findTarget(arr, target, index+1);
	}
}
