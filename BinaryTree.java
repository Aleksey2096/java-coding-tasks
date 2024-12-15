/*
 * Implement a binary tree and perform in-order traversal
 */
class TreeNode {
	int value;
	TreeNode left, right;

	public TreeNode(int value) {
		this.value = value;
		left = right = null;
	}
}

public class BinaryTree {
	TreeNode root;

	public void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.value + " ");
			inOrderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.print("In-Order Traversal: ");
		tree.inOrderTraversal(tree.root);
	}
}
