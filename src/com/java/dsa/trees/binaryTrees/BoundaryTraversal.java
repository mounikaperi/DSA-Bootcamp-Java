import java.util.*;

public class BoundaryTraversal {
    public static void main(String[] args) {
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.left = new TreeNode(4);
     root.left.right = new TreeNode(5);
     root.right.left = new TreeNode(6);
     root.right.right = new TreeNode(7);
     List<Integer> result = printBoundary(root);
     System.out.print("Boundary Traversal: ");
     printResult(result);
    }
    private static List<Integer> printBoundary(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;
      if (!isNodeLeaf(root)) result.add(root.data);
      addLeftBoundary(root, result);
      addLeaves(root, result);
      addRightBoundary(root, result);
      return result;
    }
    private static void printResult(List<Integer> result) {
      for (int val : result) System.out.print(val + " ");
      System.out.println();
    }
    private static boolean isNodeLeaf(TreeNode root) {
      return root.left == null && root.right == null;
    }
    private static void addLeftBoundary(TreeNode root, List<Integer> result) {
      TreeNode currentNode = root.left;
      while (currentNode != null) {
        if (!isNodeLeaf(currentNode)) 
          result.add(currentNode.data);
        if (currentNode.left != null) 
          currentNode = currentNode.left;
        else 
          currentNode = currentNode.right;
      }
    }
    private static void addRightBoundary(TreeNode root, List<Integer> result) {
      TreeNode currentNode = root.right;
      List<Integer> temp = new ArrayList<Integer>();
      while (currentNode != null) {
        if (!isNodeLeaf(currentNode)) 
          temp.add(currentNode.data);
        if (currentNode.right != null) 
          currentNode = currentNode.right;
        else 
          currentNode = currentNode.left;
      }
      for (int i = temp.size()-1; i>=0; --i) result.add(temp.get(i));
    }
    private static void addLeaves(TreeNode root, List<Integer> result) {
      if (isNodeLeaf(root)) {
        result.add(root.data);
        return;
      }
      if (root.left != null) addLeaves(root.left, result);
      if (root.right != null) addLeaves(root.right, result);
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
}