import java.util.Stack;

/*
 * Find the kth smallest element in a binary search tree
 */
class TreeNode {
	int value;
	TreeNode left, right;

	TreeNode(int value) {
		this.value = value;
		left = right = null;
	}
}

public class KthSmallestInBST {
	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			if (--k == 0) {
				return current.value;
			}
			current = current.right;
		}
		return -1; // If k is out of bounds
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		int k = 2;
		System.out.println("The " + k + "th smallest element is: " + kthSmallest(root, k));
	}
}
