package com.java.dsa.hashing;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class GroupShiftedString {
    public static void main(String[] args) {
        String[] arr = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};
        ArrayList<ArrayList<String>> groups = groupShiftedString(arr);

        for (ArrayList<String> group : groups) {
            for (String s : group) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    static ArrayList<ArrayList<String>> getGroupShiftedString(String[] arr) {
        /*
        - The idea is to generate a unique hash for every group by normalizing the strings.
        - Here normalizing means making the first character of every string equal to 'a'
            by calculating the required shifts and applying it uniformly to all characters
            in cyclic fashion. 
            s = "dca" shifts = 'd'-'a' = 3
            normalized characters: 'd'-3 = 'a', 'c'-3='z', 'a'-3 = 'x'
        - The normalized string (hash) represents the shift pattern such that strings with
            the same pattern have the same hash. 
        - We use a hashmap to track these hashes, and map them to corresponding groups.
        - For each string, we compute a hash and use it to either create a new group
            or add the string to an existing group in single traversal
        */
       ArrayList<ArrayList<String>> result = new ArrayList<>();
       Map<String, Integer> map = new HashMap<>();
       for (String s: arr) {
            String hash = getHash(s);
            if (!map.containsKey(hash)) {
                map.put(hash, result.size());
                result.add(new ArrayList<>());
            }
            result.get(map.get(hash)).add(s);
       }
       return result;
    }
    static String getHash(String s) {
        int shifts = s.charAt(0) - 'a';
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            chars[i] = (char) (chars[i]-shifts);
            if (chars[i] < 'a') {
                chars[i] += 26;
            }
        }
        return new String(chars);
    }
}