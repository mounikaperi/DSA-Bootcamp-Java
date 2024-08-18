import java.util.*;
public class SortedSquaresOfArray {
    public static void main(String[] args) {
        // https://leetcode.com/problems/squares-of-a-sorted-array/description/
        int[] arr = {-4,-1,0,3,10};
        System.out.println("Squares of Sorted Array: " + Arrays.toString(sortedSquares(arr)));
    }
    private static int[] sortedSquares(int[] arr) {
        int[] sortedSquares = new int[arr.length];
        for (int i=0, j=arr.length-1, k=arr.length-1; i<=j;) {
            int startSquare = arr[i] * arr[i];
            int endSquare = arr[j] * arr[j];
            if (startSquare > endSquare) {
                sortedSquares[k--] = startSquare;
                ++i;
            } else {
                sortedSquares[k--] = endSquare;
                --j;
            }
        }
        return sortedSquares;
    }       
}
