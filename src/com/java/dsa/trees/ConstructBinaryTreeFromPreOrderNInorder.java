import java.util.*;

public class ConstructBinarytreeFromPreOrderNInorder {
    static int count = 0;
    public static void main(String[] args) {
      // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
      int[] preorder = {3,9,20,15,7};
      int[] inorder = {9,3,15,20,7};
      TreeNode root = constructBinaryTree(preorder, inorder);
  }
  private static TreeNode constructBinaryTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;
    // In preorder traversal, root will be at the start index (root -> left -> right)
    int rootValue = preorder[0];
    int rootIndex = 0;
    for (int i=0; i<inorder.length; i++) {
      if (inorder[i] == rootValue) rootIndex = i;
    }
    TreeNode root = new TreeNode(rootValue);
    // // left nodes in preorder will be from index 1 to indexOfRootInInorder and left nodes in inorder will be from 0 till root
    root.left = constructBinaryTree(Arrays.copyOfRange(preorder, 1, rootIndex+1), Arrays.copyOfRange(inorder, 0, rootIndex));
    // // right nodes in preorder will be from indexOfRootInInorder+1 till end and right nodes in inorder will be from indexOfRootInInorder+1 till end
    root.right = constructBinaryTree(Arrays.copyOfRange(preorder, rootIndex+1, preorder.length), Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));
    return root;
  }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}