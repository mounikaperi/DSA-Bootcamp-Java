package com.java.dsa.trees.binarySearchTrees;

public class RecoverBST {
    static TreeNode prev = null, first = null, second = null;
    public static void main(String[] args) {
      // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.left.right = new TreeNode(2);
      recoverTree(root);
    }
    private static void inorder(TreeNode root){
      if(root==null) return ;
      inorder(root.left);
      if(prev!=null && root.data<prev.data){
        if(first==null)
          first=prev;
        second=root;
      }
      prev=root;
      inorder(root.right);
    }
    private static void recoverTree(TreeNode root) {
      if (root==null) return ; 
      inorder(root);
      int temp=first.data;
      first.data=second.data;
      second.data=temp;
    }
}