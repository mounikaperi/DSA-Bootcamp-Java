import java.util.*;

public class DeleteNodeInBST {
    // https://leetcode.com/problems/delete-node-in-a-bst/
    public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(6);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);
      root.right.right = new TreeNode(7);
      int key = 3;
      TreeNode result = deleteTreeNode(root, key);
    }
    /**
     * For deletion, there are three scenarios:
     * - If the key to be deleted is less than root node's key, lies in left subtree
     * - If the key to be deleted is greater then root node's key, lies in right subtree
     * - If the key is equal to the root's key then the root is the node to be deleted
     * 
     * - Node with only one child or no child:
     *    - If the node to be deleted has one or no children we can simply replace the node with its child if any or set it to none.
     * - Node with two children:
     *    - Find the inorder sucessor 
     *      - smallest in the right subtree
     *      - largest in the left subtree
     *    - copy the inorder sucessor's content to the Node
     *    - Delete the inorder sucessor
     * - Leaf Node
     *    - If the node is a leaf simply remove it
    */
    private static TreeNode deleteTreeNode(TreeNode root, int key) {
      // Base case: if the root is null return null
      if (root == null) return null;
      // If the key is smaller than the root value, traverse left subtree
      if (key < root.data) {
        root.left = deleteTreeNode(root.left, key);
        return root;
      }
      // If the key is greater than the root value, traverse right subtree
      if (key > root.data) {
        root.right = deleteTreeNode(root.right, key);
        return root;
      }
      // if the root has no left subtree then return right subtree
      if (root.left == null) {
        return root.right;
      }
      // if the root has no right subtree then return left subtree
      if (root.right == null) {
        return root.left;
      }
      // If the root has both left and right subtrees 
      TreeNode successor = root.right;
      // Find the smallest in the right subtrees
      while (successor.left != null) {
        successor = successor.left;
      }
      // Move the left subtree of the root to the left of the sucessor
      successor.left = root.left;
      // The new node should be the right child of the deleted node
      root = root.right;
      return root;
    }
}
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int data) {
    this.data = data;
  }
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}