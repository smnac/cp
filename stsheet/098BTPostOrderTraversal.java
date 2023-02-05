/*
145. Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/


*/

class Solution {
    List<Integer> po;
    public List<Integer> postorderTraversal(TreeNode root) {
        po = new ArrayList<>();
        helper(root);
        return po;
    }
    
    private void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        helper(node.right);
        po.add(node.val);
    }
}
