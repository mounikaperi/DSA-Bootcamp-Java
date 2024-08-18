import java.util.ArrayList;
public class SearchTargetElement {
    static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
	    int[] arr = {10, 1, 9, 2, 3, 8, 7, 4, 6, 5, 8};
	    int target = 8;
	    boolean isTargetFound = findTarget(arr, target, 0);
		System.out.println("Is Target Found: " + isTargetFound);
		int index = findIndex(arr, target, 0);
		System.out.println("The index at which element is found: " + index);
		int lastIndex = findLastIndex(arr, target, arr.length-1);
		System.out.println("The last index at which element is found: " + lastIndex);
		ArrayList<Integer> resultList = findAllIndices(arr, target, 0);
		System.out.println("The indices matching the target element is: " + resultList);
		ArrayList<Integer> resultList1 = findAllIndices1(arr, target, 0);
		System.out.println("The indices matching the target element is: " + resultList1);
	}
	private static boolean findTarget(int[] arr, int target, int index) {
	    if (index == arr.length) return false;
	    return arr[index] == target || findTarget(arr, target, index+1);
	}
	private static int findIndex(int[] arr, int target, int index) {
	    if (index == arr.length) return -1;
	    if (arr[index] == target) return index;
	    return findIndex(arr, target, index+1);
	}
	private static int findLastIndex(int[] arr, int target, int index) {
	    if (index == -1) return -1;
	    if (arr[index] == target) return index;
	    return findLastIndex(arr, target, index-1);
	}
	private static ArrayList<Integer> findAllIndices(int[] arr, int target, int index) {
	    if (index == arr.length) return list;
	    if (arr[index] == target) list.add(index);
	    findAllIndices(arr, target, index+1);
	    return list;
	}
	private static ArrayList<Integer> findAllIndices1(int[] arr, int target, int index) {
	    ArrayList<Integer> list1 = new ArrayList<Integer>();
	    if (index == arr.length) return list1;
	    if (arr[index] == target) list1.add(index);
	    ArrayList<Integer> ansFromAboveRecursionCalls = findAllIndices1(arr, target, index+1);
	    list1.addAll(ansFromAboveRecursionCalls);
	    return list1;
	}
}
