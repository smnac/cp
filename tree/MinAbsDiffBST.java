
public class MinAbsDiffBST {
	int prev = -1, mindiff = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return mindiff;
		
		getMinimumDifference(root.left);
		
		if (prev != -1)
			mindiff = Math.min(mindiff, root.val - prev);
		prev = root.val;
		
		getMinimumDifference(root.right);
		return mindiff;

	}

}
