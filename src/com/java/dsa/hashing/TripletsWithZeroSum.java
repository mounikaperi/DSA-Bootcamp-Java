package com.java.dsa.hashing;

import java.util.*;

public class TripletsWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        List<List<Integer>> res = findTriplets(arr);
        for (List<Integer> triplet : res)
            System.out.println(triplet.get(0) + " " + triplet.get(1)
                    + " " + triplet.get(2));
        res = findTripletsExpected(arr);
        for (List<Integer> triplet : res)
            System.out.println(triplet.get(0) + " " + triplet.get(1)
                    + " " + triplet.get(2));
    }
    static List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> tripletsList = new ArrayList<>();
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k = j+1; k<n; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                        List<Integer> currentList = new ArrayList<>();
                        currentList.add(i);
                        currentList.add(j);
                        currentList.add(k);
                        tripletsList.add(currentList);
                    }
                }
            }
        }
        return tripletsList;
    }
    static List<List<Integer>> findTripletsExpected(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> tripletsList = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                map.computeIfAbsent(arr[i] + arr[j], k -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        for (int i=0; i<n; i++) {
            int remainingSum = -arr[i];
            if (map.containsKey(remainingSum)) {
                List<int[]> pairs = map.get(remainingSum);
                for (int[] p: pairs) {
                    if (p[0] !=i && p[1]!=i) {
                        List<Integer> currentList = new ArrayList<>(Arrays.asList(i, p[0], p[1]));
                        Collections.sort(currentList);
                        tripletsList.add(currentList);
                    }
                }
            }
        }
        List<List<Integer>> finalList = new ArrayList<>(tripletsList);
        return finalList;
    }
}
