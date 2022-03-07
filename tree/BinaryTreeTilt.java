
/*Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if the node does not have a right child.*/

public class BinaryTreeTilt {
	
	 int sum;
	    public int findTilt(TreeNode root) {
	        sum=0;
	        calculateSum(root);
	        return sum;
	        
	    }
	    
	    public int calculateSum(TreeNode root)
	    {
	        if(root==null)
	            return 0;
	        
	        int left=calculateSum(root.left);
	        int right=calculateSum(root.right);
	        int tilt=Math.abs(left-right);
	        sum+=tilt;
	        return root.val + left + right;
	        
	    }

}
