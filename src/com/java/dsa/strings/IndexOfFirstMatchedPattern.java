package com.java.dsa.strings;
public class IndexOfFirstMatchedPattern {
    public static void main(String[] args) {
        String text = "gffgfg";
        String pattern = "gfg";
        System.out.println(findMatching(text, pattern));
    }
    static int findMatching(String text, String pattern) {
        int i=0;
        for (int j=0; j<text.length(); j++) {
            if (text.charAt(j) == pattern.charAt(i)) i++;
            else {
                j = j-i;
                i=0;
            }
            if (i == pattern.length()) {
                return j-i+1;
            }
        }
        return -1;
    }
}
