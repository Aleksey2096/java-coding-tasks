/*
 * Find the Height of a Binary Tree
 */
public class BinaryTreeHeight {
	TreeNode root;

	public int findHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = findHeight(node.left);
		int rightHeight = findHeight(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		BinaryTreeHeight tree = new BinaryTreeHeight();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Height of the tree: " + tree.findHeight(tree.root));
	}
}
