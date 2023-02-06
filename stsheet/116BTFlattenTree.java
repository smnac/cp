/*

https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
114. Flatten Binary Tree to Linked List

*/

class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
        
    }
}

//Iteration
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        TreeNode prev=null;
        while(cur!=null)
        {
            if(cur.left!=null)
            {
                prev=cur.left;
                while(prev.right!=null)
                    prev=prev.right;
                prev.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
        
    }
