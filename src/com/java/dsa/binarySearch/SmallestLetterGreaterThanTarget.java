package com.java.dsa.binarySearch;
public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        // https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
        char[] letters = {'c', 'f', 'g'};
        char target ='a';
        System.out.println("Next Greatest letter is: " + nextGreatestLetter(letters, target));
    }
    private static char nextGreatestLetter(char[] letters, char target) {
        int low =0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target >= letters[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return letters[low % letters.length];
    }       
}

