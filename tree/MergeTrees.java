import java.util.Stack;

public class MergeTrees {
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

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

		/*
		 * if(root1==null) return root2; if(root2==null) return root1;
		 * root1.val=root1.val+root2.val; root1.left =
		 * mergeTrees(root1.left,root2.left); root1.right =
		 * mergeTrees(root1.right,root2.right); return root1;
		 */

		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;

		Stack<TreeNode[]> stack = new Stack<>();
		stack.push(new TreeNode[] { root1, root2 });

		while (!stack.isEmpty()) {
			TreeNode[] node = stack.pop();

			if (node[0] == null || node[1] == null)
				continue;
			node[0].val += node[1].val;

			if (node[0].left == null)
				node[0].left = node[1].left;
			else
				stack.push(new TreeNode[] { node[0].left, node[1].left });

			if (node[0].right == null)
				node[0].right = node[1].right;
			else
				stack.push(new TreeNode[] { node[0].right, node[1].right });
		}

		return root1;

	}

}
