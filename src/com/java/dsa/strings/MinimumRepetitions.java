package com.java.dsa.strings;
public class MinimumRepetitions {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";
        System.out.println(minRepeats(s1, s2));
        System.out.println(minRepeatsKMP(s1, s2));
    }
    static int minRepeats(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        for (int i=0; i<n; i++) {
            int repetition = 1;
            boolean found = true;
            for (int j=0; j<m; j++) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    found = false;
                    break;
                }
                i++;
                if (i == n) {
                    i = 0;
                    if (j!=m-1) repetition++;
                }
            }
            if (found) return repetition;
        }
        return -1;
    }
    static int minRepeatsKMP(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();

        int[] lps = new int[m];
        computeLPSArray(s2, lps);

        int x = (m+n-1)/n;

        if (search(s1, s2, lps, x)) return x;
        if (search(s1, s2, lps, x+1)) return x+1;

        return -1;
    }
    static void computeLPSArray(String s, int[] lps) {
        int len=0, i=1;
        lps[0] = 0;

        while (i<s.length()) {
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
    }
    static boolean search(String txt, String pattern, int[] lps, int rep) {
        int n = txt.length();
        int m = pattern.length();

        int i=0, j=0;

        while (i < n*rep) {
            if (txt.charAt(i%n) == pattern.charAt(j)) {
                i++;
                j++;
                if (j==m)
                    return true;
            } else {
                if (j!=0) j = lps[j-1];
                else i++;
            }
        }

        return false;
    }
}
