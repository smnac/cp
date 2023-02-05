/*

https://leetcode.com/problems/binary-tree-right-side-view/
199. Binary Tree Right Side View
*/

class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        
            List<Integer> res = new ArrayList<>();
             helper(root,0,res);
             return res;
    }
    
    private void helper(TreeNode root,int level, List<Integer> res)
    {
        if(root==null)
            return;
        
         if(level==res.size())
             res.add(root.val);
      
        helper(root.left,level+1,res);
        helper(root.right,level+1,res);
       
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
            List<Integer> res = new ArrayList<>();
             helper(root,0,res);
             return res;
    }
    
    private void helper(TreeNode root,int level, List<Integer> res)
    {
        if(root==null)
            return;
        
         if(level==res.size())
             res.add(root.val);
        
        helper(root.right,level+1,res);
        helper(root.left,level+1,res);
    }
}
