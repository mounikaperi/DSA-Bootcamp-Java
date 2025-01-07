package com.java.dsa.strings;

import java.util.*;
class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>(52); // 26 lowercase, 26 uppercase
        for (int i=0; i<s.length(); i++) {
            // Merge the current character into the map, increasing its count by 1
            frequencyMap.merge(s.charAt(i), 1, Integer::sum);
        }
        List<Character> characters = new ArrayList<>(frequencyMap.keySet()); // for sorting
        characters.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        StringBuilder sortedString = new StringBuilder();
        for (char c : characters) {
            // Append each character to the StringBuilder based on its frequency
            for (int frequency = frequencyMap.get(c); frequency > 0; --frequency) {
                sortedString.append(c);
            }
        }
        return sortedString.toString();
    }
    public static void main(String[] args) {
      String s = "cccaaa";
      String result = frequencySort(s);
      System.out.println("The sorted string is: " + result);
    }
}
