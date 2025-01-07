package com.java.dsa.trees.binaryTrees;

public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
		TreeNode1 root = new TreeNode1(3);
		root.left = new TreeNode1(9);
		root.right = new TreeNode1(20);
		root.right.left = new TreeNode1(15);
		root.right.right = new TreeNode1(7);
		TreeNode1 result = connect(root);
	}
	private static TreeNode1 connect(TreeNode1 root) {
	    if (root == null) return null;
		TreeNode1 leftMost = root;
	    while (leftMost.left != null) {
			TreeNode1 current = leftMost; // traverse level wise here from left to right
	        while (current != null) {   
	            current.left.next = current.right;
	            if (current.next != null) {
	                current.right.next = current.next.left;
	            }
	            current = current.next;
	        }
	        leftMost = leftMost.left;
	    }
	    return root;
	}
}
class TreeNode1 {
    int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1 next;
	TreeNode1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}