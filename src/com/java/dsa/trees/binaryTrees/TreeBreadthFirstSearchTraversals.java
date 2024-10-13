import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class TreeBreadthFirstSearchTraversals {
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		List<List<Integer>> result = levelOrder(root);
		for (List<Integer> list : result) {
		    for (int value: list) {
		        System.out.print(value + " ");
		    }
		    System.out.println();
		}
        System.out.println("---------------------------");
        List<List<Integer>> result = levelOrderViaRecursion(root);
		for (List<Integer> list : result) {
		    for (int value: list) {
		        System.out.print(value + " ");
		    }
		    System.out.println();
		}
	}
	private static List<List<Integer>> levelOrder(Node root) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (root == null) return result;
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(root);
	    while (!queue.isEmpty()) {
	       int levelSize = queue.size();
	       List<Integer> currentLevel = new ArrayList<>(levelSize);
	       for (int i=0; i<levelSize; i++) {
	           Node currentNode = queue.poll();
	           currentLevel.add(currentNode.data);
	           if (currentNode.left != null) {
	               queue.offer(currentNode.left);
	           }
	           if (currentNode.right != null) {
	               queue.offer(currentNode.right);
	           }
	       }
	       result.add(currentLevel);
	    }
	    return result;
	}
    private static List<List<Integer>> levelOrderViaRecursion(Node root) {
        List<List<Integer>> out = new ArrayList<>();
        bfs(root,0,out);
        return out;
    }
    private static void bfs(Node root, int height, List<List<Integer>> out){
        if(root==null)  return;
        Node left = (root.left!=null ? root.left : null);
        Node right = (root.right!=null ? root.right : null);
        if(height>=out.size()){
            List<Integer> tmp = new ArrayList<>();
            out.add(tmp);
            tmp.add(root.data);
        }
        else{
            out.get(height).add(root.data);
        }

        bfs(left,height+1,out);
        bfs(right,height+1,out);
    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}