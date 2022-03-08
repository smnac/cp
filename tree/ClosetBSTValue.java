/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
		
		Input: root = [4,2,5,1,3], target = 3.714286
		Output: 4*/

public class ClosetBSTValue {

	public int closestValue(TreeNode root, double target) {
		int ret = root.val;
		while (root != null) {
			if (Math.abs(target - root.val) < Math.abs(target - ret)) {
				ret = root.val;
			}
			root = root.val > target ? root.left : root.right;
		}
		return ret;

	}

}
