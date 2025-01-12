package com.java.dsa.strings;

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        String s = "aabcdaabc";
        System.out.println(longestPrefixSuffixNaive(s));
        System.out.println(longestPrefixSuffix(s));
    }
    static int longestPrefixSuffixNaive(String s) {
        int res = 0;
        int n = s.length();

        for (int len=1; len<n; len++) {
            int j = s.length()-len;
            boolean flag = true;
            for (int k=0; k<len; k++) {
                if (s.charAt(k) != s.charAt(j+k)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res = len;
        }
        return res;
    }
    static int longestPrefixSuffix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        lps[0] = 0;
        int i=1;
        while (i<n) {
            if (s.charAt(i) == s.charAt(len)) {
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
        return lps[n-1];
    }
}
