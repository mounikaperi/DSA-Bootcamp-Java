package com.java.dsa.hashing;

import java.util.*;

public class GroupAnagrams {
    static final int MAX_CHAR = 26;
    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> res = anagrams(arr);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
        System.out.println("---------------");
        ArrayList<ArrayList<String>> res1 = anagramsExpected(arr);

        for (List<String> group : res1) {
            for (String word : group) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
    static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Time Complexity: O(n * k * log(k)), where n is the number of words and k is the maximum length of a word.
        // Auxiliary Space: O(n * k), to store the result.
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            String s = arr[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            if (!map.containsKey(s)) {
                map.put(s, result.size());
                result.add(new ArrayList<>());
            }
            result.get(map.get(s)).add(arr[i]);
        }
        return result;
    }
    static ArrayList<ArrayList<String>> anagramsExpected(String[] arr) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            String key = getHash(arr[i]);
            if (!map.containsKey(key)) {
                map.put(key, result.size());
                result.add(new ArrayList<>());
            }
            result.get(map.get(key)).add(arr[i]);
        }
        return result;
    }
    static String getHash(String s) {
        StringBuilder hash = new StringBuilder();
        int[] freq = new int[MAX_CHAR];
        for (char ch: s.toCharArray())
            freq[ch-'a']++;
        for (int i=0; i<MAX_CHAR; i++) {
            hash.append(freq[i]);
            hash.append("$");
        }
        return hash.toString();
    }
}
