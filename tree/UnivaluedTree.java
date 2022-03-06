
/*A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.*/

public class UnivaluedTree {
	
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	 public boolean isUnivalTree(TreeNode root) {
	        if(root==null)
	            return true;
	        
	        if(root.left!=null)
	            if(root.val!=root.left.val)
	                return false;
	        
	        if(root.right!=null)
	            if(root.val!=root.right.val)
	                return false;
	        
	        
	        return isUnivalTree(root.left) && isUnivalTree(root.right);
	        
	        
	        
	        
	        
	    }
	 
		/*
		 * public boolean isUnivalTree(TreeNode root) { boolean left_correct =
		 * (root.left == null || (root.val == root.left.val &&
		 * isUnivalTree(root.left))); boolean right_correct = (root.right == null ||
		 * (root.val == root.right.val && isUnivalTree(root.right))); return
		 * left_correct && right_correct; }
		 */

}
