import java.util.List;
import java.util.ArrayList;
public class TreeDepthFirstSearchTraversals {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> list = getTreeTraversal(root);
        System.out.print("Inorder Traversal: ");
        for (int val : list.get(0)) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.print("Preorder Traversal: ");
        for (int val : list.get(1)) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.print("Postorder Traversal: ");
        for (int val : list.get(2)) {
            System.out.print(val + " ");
        }
        System.out.println();
	}
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        getInorderTraversal(root, inorderList);
        list.add(inorderList);
        List<Integer> preorderList = new ArrayList<>();
        getPreorderTraversal(root, preorderList);
        list.add(preorderList);
        List<Integer> postorderList = new ArrayList<>();
        getPostorderTraversal(root, postorderList);
        list.add(postorderList);
        return list;
    }
    private static void getPreorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.data);
        getPreorderTraversal(root.left, list);
        getPreorderTraversal(root.right, list);
    }
    private static void getInorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getInorderTraversal(root.left, list);
        list.add(root.data);
        getInorderTraversal(root.right, list);
    }
    private static void getPostorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getPostorderTraversal(root.left, list);
        getPostorderTraversal(root.right, list);
        list.add(root.data);
    }
}
class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
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