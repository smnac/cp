/*
https://leetcode.com/problems/balanced-binary-tree/
110. Balanced Binary Tree

*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;
        
        return height(root)!=-1;
        
    }
    
    private int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = height(root.left);
        if(left==-1)
            return -1;
        int right = height(root.right);
        if(right==-1)
            return -1;
        
        if(Math.abs(left-right)>1) return -1;
        return 1+Math.max(left, right);
    }
}
