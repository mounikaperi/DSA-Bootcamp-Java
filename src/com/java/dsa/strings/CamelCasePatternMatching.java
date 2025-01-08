package com.java.dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class CamelCasePatternMatching {
    public static void main(String[] args) {
        String[] arr = {"WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks", "WayToGo" };
        String pat = "WTG";
        List<String> res = camelCaseMatchingNaive(arr, pat);
        for (String s : res) System.out.print(s + " ");
    }
    static List<String> camelCaseMatchingNaive(String[] arr, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word: arr) {
            int i=0, j=0;
            while (i < word.length() && j<pattern.length()) {
                if (Character.isLowerCase(word.charAt(i))) i++; // If ith character of word is lowercase character, move to next character
                else if (word.charAt(i) != pattern.charAt(j)) break; // if ith character of word is an uppercase character and does not match with the jth character of pattern move to the next word
                else {
                    // if ith character of word is an uppercase character and matches with the jth character of pattern move to the next characters
                    i++;
                    j++;
                }
            }
            if (j==pattern.length()) result.add(word);
        }
        return result;
    }
}
