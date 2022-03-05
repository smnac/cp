import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.*/

public class FindLonelyNodes {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> getLonelyNodes(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preorder(root, res);
		return res;

	}

	void preorder(TreeNode root, List<Integer> res) {
		if (root == null || (root.left == null && root.right == null))
			return;

		if (root.left == null && root.right != null)
			res.add(root.right.val);

		if (root.right == null && root.left != null)
			res.add(root.left.val);

		preorder(root.left, res);
		preorder(root.right, res);
	}

	void preorderStack(TreeNode root, List<Integer> res) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			if (node.left != null) {
				stack.push(node.left);
				if (node.right == null)
					res.add(node.left.val);
			}

			if (node.right != null) {
				stack.push(node.right);
				if (node.left == null)
					res.add(node.right.val);
			}

		}

	}

}
