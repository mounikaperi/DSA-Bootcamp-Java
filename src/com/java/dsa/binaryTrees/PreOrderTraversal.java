import java.util.List;
import java.util.ArrayList;
public class PreOrderTraversal {
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> result = preOrderTraversal(root);
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
	}
	private static List<Integer> preOrderTraversal(Node root) {
	    List<Integer> arr = new ArrayList<>();
	    preorder(root, arr);
	    return arr;
	}
	private static void preorder(Node root, List<Integer> arr) {
	    if (root == null) return;
	    arr.add(root.data);
	    preorder(root.left, arr);
	    preorder(root.right, arr);
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
