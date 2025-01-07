package com.java.dsa.trees.binaryTrees;

import java.util.*;

public class BottomViewOfBinaryTree {
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
        List<Integer> bottomView = bottomView(root);
        System.out.println("Vertical Traversal: ");
        for (int TreeNode : bottomView) {
            System.out.print(TreeNode + " ");
        }
    }
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            mpp.put(level, node.val);
            if (node.left != null)  q.add(new Pair(node.left, level - 1));
            if (node.right != null) q.add(new Pair(node.right, level + 1));
        }
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}