package com.java.dsa.recursion;
public class TrianglePattern {
	public static void main(String[] args) {
		reverseTriangle(4, 0);
		triangle(4, 0);
	}
	private static void reverseTriangle(int row, int col) {
	    if (row == 0) return;
	    if (col < row) {
	        System.out.print("*");
	        reverseTriangle(row, col+1);
	    } else {
	        System.out.println();
	        reverseTriangle(row-1, 0);
	    }
	}
	private static void triangle(int row, int col) {
	    if (row == 0) return;
	    if (col < row) {
	        triangle(row, col+1);
	        System.out.print("*");
	    } else {
	        triangle(row-1, 0);
	        System.out.println();
	    }
	}
}
