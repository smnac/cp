
public class DiameterOfTree {

	int diameter;

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		longestPath(root);
		return diameter;

	}

	private int longestPath(TreeNode root) {
		if (root == null)
			return 0;

		int leftPath = longestPath(root.left);
		int rightPath = longestPath(root.right);
		diameter = Math.max(diameter, leftPath + rightPath);
		return Math.max(leftPath, rightPath) + 1;
	}

}
