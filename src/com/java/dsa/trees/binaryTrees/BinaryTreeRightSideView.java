package com.java.dsa.trees.binaryTrees;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class BinaryTreeRightSideView {
    private static List<Integer> result;
	public static void main(String[] args) {
	    // https://leetcode.com/problems/binary-tree-right-side-view/
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Integer> listResult1 = rightSideViewUsingRecursion(root);
		for (int value: listResult1) {
		    System.out.print(value + " ");
		}
		System.out.println();
		System.out.println("---------------------");
		List<Integer> listResult2 = rightSideView(root);
		for (int value: listResult2) {
		    System.out.print(value + " ");
		}
		System.out.println();
	}
    private static List<Integer> rightSideViewUsingRecursion(TreeNode root) {
        result = new ArrayList<Integer>();
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }
    private static void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == result.size()) result.add(root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize-1) result.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return result;
    }
}