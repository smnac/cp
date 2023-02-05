/*

https://leetcode.com/problems/binary-tree-inorder-traversal/
94. Binary Tree Inorder Traversal

*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
          dfs(root);
          return res;  
    }
    
    private void dfs(TreeNode root)
    {
        if(root==null)
            return;
            
            dfs(root.left);
            res.add(root.val);
            dfs(root.right);
    }
    
    
    
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
    TreeNode cur=root;
        
        while(true)
        {
            if(cur!=null)
            {
                stack.push(cur);
                cur=cur.left;
            }
            else
            {
                if(stack.isEmpty())
                    break;
                else
                {
                    TreeNode node = stack.pop();
                    inorder.add(node.val);
                    cur=node.right;
                }
            }
        }
        return inorder;
        
    }
}
