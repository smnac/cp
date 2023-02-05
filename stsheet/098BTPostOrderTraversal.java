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

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> postorder = new ArrayList<>();
        if(root==null)
            return postorder;
            
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode cur=stack1.pop();
            stack2.push(cur);
            if(cur.left!=null)
                stack1.push(cur.left);
            if(cur.right!=null)
                stack1.push(cur.right);
        }

        while(!stack2.isEmpty())
            postorder.add(stack2.pop().val);
        return postorder;
        
        
    }
}
