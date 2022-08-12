/*
235. Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
*/


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        
            return root;
    }
}
