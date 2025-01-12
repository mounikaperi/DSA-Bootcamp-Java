package com.java.dsa.strings;

public class MinCharsToAddForPalindrome {
    public static void main(String[] args) {
        String str = "aacecaaaa";
        System.out.println(minChar(str));
        str = "aacecaaaa";
        System.out.println(minCharPrefixSuffix(str));
    }
    static int minChar(String s) {
        int count = 0;
        int i = s.length()-1;
        while (i>=0 && !isPalindrome(s, 0, i)) {
            // iterate from the end of the string checking for the longest palindrome starting from beginning
            i--;
            count++;
        }
        return count;
    }
    static boolean isPalindrome(String s, int i, int j) {
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static int minCharPrefixSuffix(String s) {
        /**
         *         1. concatenate the given string with $ and with reverse of the given string
         *         2. Lets see how different values of last element of lps[] array will help us finding largest palindrome prefix
         *         3. if the last value of lps[] is 1, then it means that the last character of the reversed string matches
         *            with the first character of the input string so s0 = s0 therefore s0 is palindrome
         *         4. if the last value of lps[] is 2, then it means that the last 2 characters of the reversed string matches
         *            with the first 2 characters of the input string so s0s1 = s1s0 therefore s0s1 is palindrome
         *         5. If the last value of lps[] is 3, then it means that the last 3 characters of the reversed string matches
         *            with the first 3 characters of the input string so s0s1s2 = s2s1s0 therefore s0s1s2 is palindrome
         *         6. If the last value of lps[] is 4, then it means that the last 4 characters of the reversed string matches
         *            with the first 4 characters of the input string so s0s1s2s3s4 = s4s3s2s1s0 therefore s0s1s2s3 is palindrome
         *         7. If the last value of lps[] is 5, then it means that the last 5 characters of the reversed string matches
         *            with the first 5 characters of the input string so s0s1s2s3s4 = s4s3s2s1s0 therefore s0s1s2s3s4 is palindrome
         */
         int n = s.length();
         String rev = new StringBuilder(s).reverse().toString();
         s = s + "$" + rev;
         int[] lps = computeLPSArray(s);
         return (n - lps[lps.length-1]); // By subtracting last entry of lps[] from string length we will get result
    }

    static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        lps[0] = 0;
        int len = 0;
        int i=1;
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
