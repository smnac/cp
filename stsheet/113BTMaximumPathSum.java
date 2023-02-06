/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
124. Binary Tree Maximum Path Sum

*/

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0]=Integer.MIN_VALUE;
          helper(root,maxSum);
        return maxSum[0];
        
    }
    
    private int helper(TreeNode root, int[] maxSum)
    {
        if(root==null)
            return 0;
        
        int left = Math.max(0,helper(root.left,maxSum));
        int right = Math.max(0,helper(root.right,maxSum));
        maxSum[0]=Math.max(maxSum[0],root.val+left+right);
        return root.val + Math.max(left, right) ;
    }
}
