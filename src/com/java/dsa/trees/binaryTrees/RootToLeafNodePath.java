import java.util.*;

public class RootToLeafNodePath {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);
      int targetLeafValue = 7;
      List<Integer> result = solve(root, targetLeafValue);
      System.out.print("Path from root to leaf with value " + targetLeafValue + ": ");
      for (int i = 0; i < result.size(); ++i) {
        System.out.print(result.get(i));
        if (i < result.size() - 1) {
          System.out.print(" -> ");
        }
      }
    }
    private static List<Integer> solve(TreeNode root, int key) {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;
      getPath(root, result, key);
      return result;
    }
    private static boolean getPath(TreeNode root, List<Integer> result, int key) {
      if (root == null) return false;
      result.add(root.data);
      if (root.data == key) return true;
      if (getPath(root.left, result, key) || getPath(root.right, result, key)) return true;
      // if key is not found then
      result.remove(result.size()-1);
      return false;
    }
    // if there are multiple paths to reach to the leaf node
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getPath(root, new ArrayList<>(), result);
        return result;
    }
    private static void getPath(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null)
            result.add(new ArrayList<>(path));
        getPath(root.left, new ArrayList<>(path), result);
        getPath(root.right, new ArrayList<>(path), result);
        // if no path found to leaf node then remove the root that is added
        path.remove(path.size()-1);
    }
}
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  public TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}