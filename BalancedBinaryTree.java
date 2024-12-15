/*
 * Check if a binary tree is balanced
 */
public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != -1;
	}

	private static int checkHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = checkHeight(node.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(node.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("Is the tree balanced? " + isBalanced(root));
	}
}