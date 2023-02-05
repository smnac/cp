/*
https://leetcode.com/problems/binary-tree-preorder-traversal/
144. Binary Tree Preorder Traversal

*/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
                dfs(root);
                return res;  
    }
    
    private void dfs(TreeNode root)
    {
        if(root==null)
            return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> res = new ArrayList<>();
        
        if(root==null)
            return res;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
        
        return res;
    }
}
