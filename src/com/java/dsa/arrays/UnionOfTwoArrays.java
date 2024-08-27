import java.util.List;
import java.util.ArrayList;
public class UnionOfTwoArrays {
	public static void main(String[] args) {
	    // https://www.naukri.com/code360/problems/sorted-array_6613259?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse
        int[] arr1 = {1, 1, 2, 3, 5, 5, 5, 10, 10};
        int[] arr2 = {2, 4, 7, 10, 10};
        List<Integer> ans = unionOfTwoArrays(arr1, arr2);
        System.out.println("The union of two arrays is: " + ans);
	}
	private static List<Integer> unionOfTwoArrays(int[] arr1, int[] arr2) {
	    List<Integer> list = new ArrayList<>();
	    int i = 0;
	    int j = 0;
	    while (i < arr1.length && j < arr2.length) {
	        if (arr1[i] <= arr2[j]) {
	            if (!list.contains(arr1[i])) {
	                list.add(arr1[i]);
	            }
	            i++;
	        } else {
	            if (!list.contains(arr2[j])) {
	                list.add(arr2[j]);
	            }
	            j++;
	        }
	    }
	    // check for remaining elements of first array
	    while (i < arr1.length) {
	        if (!list.contains(arr1[i])) {
	           list.add(arr1[i]);
	        }
	        i++;
	    }
	    // check for remaining elements of second array
	    while (j < arr2.length) {
	        if (!list.contains(arr2[j])) {
	           list.add(arr2[j]);
	        }
	        j++;
	    }
	    return list;
	}
}
