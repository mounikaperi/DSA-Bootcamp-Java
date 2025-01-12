package com.java.dsa.strings;

public class ShortestPalindrome {
    // https://leetcode.com/problems/shortest-palindrome/description/
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
    static String shortestPalindrome(String s) {
        int n = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();
        String combinedString = s + "$" + reversedString;
        int[] lps = computeLPSArray(combinedString);
        int palindromeLength = lps[combinedString.length()-1];
        StringBuilder suffix = new StringBuilder(s.substring(palindromeLength)).reverse();
        return suffix.append(s).toString();
    }
    static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        lps[0] = 0;
        int len = 0;
        int i=1;
        while (i<patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len-1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
