import java.util.*;

public class ConstructBSTFromPreorder {
    public static void main(String[] args) {
      // 1008. https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
      int[] preorder = {8, 5, 1, 7, 10, 12};
      TreeNode result = constructBST(preorder, 0, preorder.length-1);
      System.out.println(result);
    }
    /**
     * Treat the first value as the root node since we are given preorder traversal
     * Split the remaining elements into groups
     *    One for the left subtree
     *    One for the right subtree
     * Recursively apply these steps to both left and right groups to entire tree
    */
    private static TreeNode constructBST(int[] preorder, int startIndex, int endIndex) {
      if (startIndex > endIndex || startIndex >= preorder.length-1) return null;
      TreeNode root = new TreeNode(preorder[startIndex]);
      // Find the boundary between left and right subtrees
      // The first bigger element than the root will be the root of the right subtree
      int index = findIndex(preorder, startIndex, endIndex, preorder[startIndex]);
      root.left = constructBST(preorder, startIndex+1, index-1);
      root.right = constructBST(preorder, index, endIndex);
      return root;
    }
    private static int findIndex(int[] preorder, int startIndex, int endIndex, int rootValue) {
      int left = startIndex + 1;
      int right = endIndex + 1;
      while (left < right) {
        int mid = (left + right) >> 1; // Equivalent to (left + right) / 2 but faster
        if (preorder[mid] > rootValue) 
          right = mid;
        else 
          left = mid + 1;
      }
      return left;
    }
}
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}