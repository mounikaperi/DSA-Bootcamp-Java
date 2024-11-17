import java.util.*;

public class VerticalTraversal {
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
      List<List<Integer>> verticalTraversal = findVertical(root);
      System.out.println("Vertical Traversal: ");
      printResult(verticalTraversal);
    }
    private static void printResult(List<List<Integer>> result) {
      for (List<Integer> level : result) {
        for (int node : level) 
          System.out.print(node + " ");
        System.out.println();
      }
      System.out.println();
    }
    private static List<List<Integer>> findVertical(TreeNode root) {
      TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
      Queue<Pair> queue = new LinkedList<Pair>();
      queue.offer(new Pair(root, 0, 0));
      while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        TreeNode node = pair.node;
        int vertical = pair.vertical;
        int level = pair.level;
        if (!map.containsKey(vertical)) {
          map.put(vertical, new TreeMap<>());
        }
        if (!map.get(vertical).containsKey(level)) {
          map.get(vertical).put(level, new PriorityQueue<>());
        }
        map.get(vertical).get(level).offer(node.data);
        if (node.left != null)
          queue.offer(new Pair(node.left, vertical-1, level+1));
        if (node.right != null)
          queue.offer(new Pair(node.right, vertical+1, level+1));
      }
      List<List<Integer>> list = new ArrayList<>();
      for (TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()) {
        list.add(new ArrayList<>());
        for (PriorityQueue<Integer> nodes: ys.values()) {
          while (!nodes.isEmpty()) {
            list.get(list.size()-1).add(nodes.poll());
          }
        }
      }
      return list;
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
class Pair {
  TreeNode node;
  int vertical;
  int level;
  public Pair(TreeNode node, int vertical, int level) {
    this.node = node;
    this.vertical = vertical;
    this.level = level;
  }
}