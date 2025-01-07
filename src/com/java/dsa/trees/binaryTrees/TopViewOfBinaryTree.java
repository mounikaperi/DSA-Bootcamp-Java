package com.java.dsa.trees.binaryTrees;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        List<Integer> topView = topView(root);
        System.out.println("Vertical Traversal: ");
        for (int TreeNode : topView) {
            System.out.print(TreeNode + " ");
        }
    }
    public static List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (!mpp.containsKey(level)) mpp.put(level, node.val);
            if (node.left != null)  q.add(new Pair(node.left, level - 1));
            if (node.right != null) q.add(new Pair(node.right, level + 1));
        }
        for (int value : mpp.values()) {
            ans.add(value);
        }
        return ans;
    }
}