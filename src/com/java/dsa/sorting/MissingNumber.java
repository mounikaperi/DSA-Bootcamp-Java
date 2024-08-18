public class MissingNumber {
    public static void main(String[] args) {
        // https://leetcode.com/problems/missing-number/description/
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println("Missing number is: " + findMissingNumber1(arr));
        System.out.println("Missing number is: " + findMissingNumber2(arr));
    }
    private static int findMissingNumber1(int[] arr) {
        // Find missing number using Cycle Sort
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i]; // as numbers start from 0; if they start from 1 then it is arr[i] - 1;
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) swap(arr, i, correctIndex);
            else i++;
        }
        for (int index = 0; index < arr.length; index++) 
            if (index != arr[index]) return index;
        return arr.length;
    }
    private static int findMissingNumber2(int[] arr) {
        // Find Missing number using sum of n natural numbers
        int n = arr.length;
        int actualSum = n*(n+1)/2;
        int calculatedSum = 0;
        for (int num: arr) calculatedSum += num;
        return actualSum - calculatedSum;
    }
    private static void swap(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}

