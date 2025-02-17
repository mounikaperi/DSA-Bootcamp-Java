package com.java.dsa.slidingwindowtwopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistinctQuadruplets {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int target = 23;
        List<List<Integer>> ans = fourSum(arr, target);
        for (List<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> fourSumNaive(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    for (int l=k+1; l<n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> curr = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                            Collections.sort(curr);
                            if (!result.contains(curr)) {
                                result.add(curr);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    static List<List<Integer>> fourSumHashing(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k=j+1; k<n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    int last = target - sum;
                    if (set.contains(last)) {
                        List<Integer> currList = Arrays.asList(arr[i], arr[j], arr[k], last);
                        Collections.sort(currList);
                        resultSet.add(currList);
                    }
                    set.add(arr[k];)
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
    static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i=0; i<n;i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            for (int j=i+1;j<n; j++) {
                if (j > i+1 && arr[j] == arr[j-1]) continue;
                int left = j+1, right=n-1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left-1]) left++;
                        while (left < right && arr[right] == arr[right+1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }
}