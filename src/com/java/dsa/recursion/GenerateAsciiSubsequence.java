package com.java.dsa.recursion;

import java.util.ArrayList;
public class GenerateAsciiSubsequence {
	public static void main(String[] args) {
	    String s = "abc";
		System.out.println("The ASCII value is: " + generateAsciiSubSequence("", s));
	}
	private static ArrayList<String> generateAsciiSubSequence(String p, String inputString) {
	    if (inputString.isEmpty()) {
	        ArrayList<String> list = new ArrayList<>();
	        list.add(p);
	        return list;
	    }
	    char ch = inputString.charAt(0);
	    ArrayList<String> first = generateAsciiSubSequence(p+ch, inputString.substring(1));
	    ArrayList<String> second = generateAsciiSubSequence(p, inputString.substring(1));
	    ArrayList<String> third = generateAsciiSubSequence(p+(ch+0), inputString.substring(1));
	    first.addAll(second);
	    first.addAll(third);
	    return first;
	}   
}
