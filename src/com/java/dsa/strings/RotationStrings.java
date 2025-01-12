package com.java.dsa.strings;

public class RotationStrings {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";

        System.out.println(areRotationsNaive(s1, s2));
        System.out.println(areRotationsKMP(s1, s2));
        System.out.println(areRotationsBuiltIn(s1, s2));
    }
    static boolean areRotationsNaive(String s1, String s2) {
        int n = s1.length();
        for (int i=0; i<n; i++) {
            if (s1.equals(s2)) return true; // If current rotation is equal to s2 return true
            char last = s1.charAt(s1.length()-1); // right rotate s1
            s1 = last + s1.substring(0, s1.length()-1);
        }
        return false;
    }
    static boolean areRotationsKMP(String s1, String s2) {
        String text = s1 + s2;
        String pattern = s2;
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int textPointer=0, patternPointer=0;
        while (textPointer<textLength) {
            if (pattern.charAt(patternPointer) == text.charAt(textPointer)) {
                textPointer++;
                patternPointer++;
                if (patternPointer == patternLength) return true;
            } else if (textPointer < textLength && pattern.charAt(patternPointer) != text.charAt(textPointer)) {
                if (patternPointer!=0) patternPointer = lps[patternPointer-1];
                else textPointer = textPointer+1;
            }
        }
        return false;
    }
    static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        int lengthPointer = 0;
        lps[0] = 0;
        int i = 1;
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(lengthPointer)) {
                lengthPointer++;
                lps[i] = lengthPointer;
                i++;
            } else {
                if (lengthPointer != 0)
                    lengthPointer = lps[lengthPointer-1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    static boolean areRotationsBuiltIn(String s1, String s2) {
        s1 = s1 + s1;
        return s1.contains(s2);
    }
}
