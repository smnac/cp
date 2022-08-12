/* 98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/



class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long minVal, long maxVal){
        if(root==null){
            return true;
        }
        
        if(root.val <= minVal || root.val >= maxVal){
            return false;
        }
        
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}

