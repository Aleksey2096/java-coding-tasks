/*
 * Check if Two Binary Trees are Identical
 */
public class IdenticalBinaryTrees {
	public static boolean areIdentical(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}
		if (tree1 == null || tree2 == null) {
			return false;
		}
		return (tree1.value == tree2.value)
				&& areIdentical(tree1.left, tree2.left)
				&& areIdentical(tree1.right, tree2.right);
	}

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(1);
		tree1.left = new TreeNode(2);
		tree1.right = new TreeNode(3);

		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(3);

		System.out.println("Are trees identical? " + areIdentical(tree1, tree2));
	}
}
