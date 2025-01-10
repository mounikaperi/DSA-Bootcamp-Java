package com.java.dsa.arrays;

public class SplitArrayInThreeEqualSumSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 4};
        int[] res = findSplit(arr);
        System.out.println(res[0] + " " + res[1]);
        res = findSplitExpected(arr);
        System.out.println(res[0] + " " + res[1]);
    }
    static int[] findSplit(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n-2; i++) { // First partition
            for (int j=i+1; j<n-1; j++) { // Second partition
                int sum1 = findSum(arr, 0, i);
                int sum2 = findSum(arr, i+1, j);
                int sum3 = findSum(arr, j+1, n-1);
                if (sum1 == sum2 && sum2 == sum3)
                    return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
    static int findSum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i=start; i<=end; i++) sum += arr[i];
        return sum;
    }
    static int[] findSplitExpected(int[] arr) {
        /*
            To split the array into three equal segments, we first need to make sure that the total sum of the array
            is divisible by 3. Then, as we iterate through the array, we calculate the running sum.

            If running sum becomes equal to one-third of the total, we reset the running sum to zero and store the index
            as the first element of the index pair.

            if we find another index for which the running sum becomes equal to one third of total and there are still
            elements left for a third segment, then store the index as second element of the index pair and return the
            index pair

            we only need the first two segments with sum = 1/3rd of total because the remaining subarray will always be
            the third segment
         */
        int[] res = new int[2];
        int n = arr.length;
        int resIndex = 0;
        int total = 0;

        for (int i=0; i<n; i++) total += arr[i];

        if (total % 3 != 0) {
            // If the total sum is not divisible by 3, it's not impossible to split the array
            res[0] = -1; res[1] = -1; return res;
        }
        int currSum = 0;
        for (int i=0; i<n; i++) {
            currSum += arr[i];
            if (currSum == total/3) {
                currSum = 0;
                res[resIndex++] = i;
                if (resIndex == 2 && i<n-1) return res; // If two valid segments are found and third nonempty segment is possible return true
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}
