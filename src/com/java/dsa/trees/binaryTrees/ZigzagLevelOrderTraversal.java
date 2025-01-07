package com.java.dsa.trees.binaryTrees;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class ZigzagLevelOrderTraversal {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = zigzagOrder(root);
		for (List<Integer> list: result) {
		    for (int value: list) {
		        System.out.print(value + " ");
		    }
		    System.out.println();
		}
	}
    private static List<List<Integer>> zigzagOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                if (!reverse) { // if reverse flag is false, add it at last and remove it at first
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) queue.addLast(currentNode.left); // add left then right
                    if (currentNode.right != null) queue.addLast(currentNode.right);
                } else { // remove from back and add it at front 
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) queue.addFirst(currentNode.right); // add right then left
                    if (currentNode.left != null) queue.addFirst(currentNode.left);
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }
}