import java.util.*;
public class IntersectionOfTwoArrays1 {
    public static void main(String[] args) {
        // https://leetcode.com/problems/intersection-of-two-arrays/description/
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9,4,9,8,4};
        System.out.println("intersection-of-two-arrays: " + Arrays.toString(intersection(arr1, arr2)));
    }
    private static int[] intersection(int[] arr1, int[] arr2) {
       boolean[] booleanArray = new boolean[1001];
       int[] tempArray = new int[arr2.length];
       int k = 0;
       for (int num: arr1) booleanArray[num] = true;
       for (int num: arr2) {
           if (booleanArray[num]) tempArray[k++] = num;
           booleanArray[num] = false;
       }
       int[] resultArray = new int[k];
       for (int i=0; i<k; i++) resultArray[i] = tempArray[i];
       return resultArray;
    }       
}

