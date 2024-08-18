package com.java.dsa.arrays;

import java.util.*;

public class CheckIfSentenceIsPanagram {
	public static void main(String[] args) {
		String str = "thequickbrownfoxjumpsoverthelazydog";
		System.out.println("Is Sentence panagram? " + isSentencePanagram1(str));
		System.out.println("Is Sentence panagram? " + isSentencePanagram2(str));
		System.out.println("Is Sentence panagram? " + isSentencePanagram3(str));
	}
	private static boolean isSentencePanagram1(String str) {
	    // TC: O(N) SC: O(1)
	    if (str.length() < 26) return false;
	    for (char ch = 'a'; ch<='z'; ch++) {
	        if (str.indexOf(ch) == -1) return false;
	    }
	    return true;
	}
	private static boolean isSentencePanagram2(String str) {
	    // TC: O(N) SC: O(1)
	    HashSet<Character> hs = new HashSet<>();
	    for(int i=0; i<str.length(); i++)
	        hs.add(str.charAt(i));
	    return hs.size() == 26;
	}
	private static boolean isSentencePanagram3(String str) {
	    // TC: O(N) SC: O(1)
	    HashMap<Character, Integer> hs = new HashMap<>();
	    for(int i=0; i<str.length(); i++)
	        hs.put(str.charAt(i), hs.getOrDefault(str.charAt(i), 0) + 1);
	    return hs.size() == 26;
	}
}
