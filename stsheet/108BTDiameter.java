/*
https://leetcode.com/problems/diameter-of-binary-tree/
543. Diameter of Binary Tree
*/
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
          int[] diameter = new int[1];
        diameter[0]=Integer.MIN_VALUE;
        height(root,diameter);
        return diameter[0];
    }
    
    private int height(TreeNode root, int[] dia)
    {
        if(root==null)
            return 0;
        
        int left = height(root.left,dia);
        int right = height(root.right,dia);
        dia[0]=Math.max(dia[0],left+right);
        return 1 + Math.max(left,right);
        
    }
}
