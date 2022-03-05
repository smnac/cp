
/*You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.*/

public class SumRootToLeaf {
	
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

	
	int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        
        helper(root,0); // preorder
        return sum;
        
    }
    
    
    void helper(TreeNode root, int number)
    {
        if(root==null)
            return;
        number=number<<1 | root.val;
        if(root.left==null && root.right==null) //leaf
            sum+=number;
        helper(root.left,number);
        helper(root.right,number);
            
    }

}
