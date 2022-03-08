

/*Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

*/

public class CousinsInBinaryTree {

	TreeNode p1, p2;  //parents
	int depth1 = -1, depth2 = -2; //initially let us have different values
	int depth = 0;

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;

		if ((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)) {
			p1 = root;
			depth1 = depth;

		}

		if ((root.left != null && root.left.val == y) || (root.right != null && root.right.val == y)) {
			p2 = root;
			depth2 = depth;

		}

		depth++;
		isCousins(root.left, x, y);
		isCousins(root.right, x, y);
		depth--;

		return depth1 == depth2 && p1 != p2;

	}

}
