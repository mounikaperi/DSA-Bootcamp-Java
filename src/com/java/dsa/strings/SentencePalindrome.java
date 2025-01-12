package com.java.dsa.strings;
public class SentencePalindrome {
    public static void main(String[] args) {
        String s = "Too hot to hoot.";
        System.out.println(sentencePalindromeNaive(s));
        System.out.println(sentencePalindrome(s));
    }
    static boolean sentencePalindromeNaive(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
            StringBuilder rev = new StringBuilder(sb.toString());
            rev.reverse();
            return sb.toString().equals(rev.toString());
        }
        return false;
    }
    static boolean sentencePalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if (!Character.isLetterOrDigit((s.charAt(j)))) j--;
            else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}
