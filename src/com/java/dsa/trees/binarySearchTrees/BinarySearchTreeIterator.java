package com.java.dsa.trees.binarySearchTrees;

import java.util.*;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(7);
      root.left = new TreeNode(3);
      root.right = new TreeNode(15);
      root.right.left = new TreeNode(9);
      root.right.right = new TreeNode(20);
      BSTIterator bstIterator = new BSTIterator(root);
      System.out.println(bstIterator.next());
      System.out.println(bstIterator.next());
      System.out.println(bstIterator.hasNext());
      System.out.println(bstIterator.next());
      System.out.println(bstIterator.hasNext());
      System.out.println(bstIterator.next());
      System.out.println(bstIterator.hasNext());
      System.out.println(bstIterator.next());
      System.out.println(bstIterator.hasNext());
    }
}

// class BSTIterator {
//     private Stack<TreeNode> stack = new Stack<TreeNode>();

//     public BSTIterator(TreeNode root) { 
//         pushAll(root);
//     }
    
//     public int next() {
//         TreeNode tempNode = stack.pop();
//         pushAll(tempNode.right);
//         return tempNode.val;
//     }
    
//     public boolean hasNext() {
//         return !stack.isEmpty();
//     }
//     private void pushAll(TreeNode node) {
//         for (; node!=null; stack.push(node), node=node.left);
//     }
// }

class BSTIterator {
    private List<Integer> l1 = new ArrayList<>();
    private int i=-1;
    private void inOrder(TreeNode root ){
        if(root==null) {
            return ;
        }
        inOrder(root.left);
        l1.add(root.data);
        inOrder(root.right);
    }
    public BSTIterator(TreeNode root) {
         inOrder(root);    
    }
    public int next() {
            i++;
            return l1.get(i);
    }
    public boolean hasNext() {
        return i+1<l1.size() ? true : false;
    }
}
