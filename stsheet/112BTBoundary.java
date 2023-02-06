/*
https://leetcode.com/problems/boundary-of-binary-tree/#
545. Boundary of Binary Tree
*/

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> left = new ArrayList<>();
         List<Integer> leaf = new ArrayList<>();
         List<Integer> right = new ArrayList<>();
        if(root==null)
            return left;
        if(root.left==null && root.right==null)
        {
            left.add(root.val);
            return left;
        }
        leftSideTree(root,left);
        getLeafs(root,leaf);
        rightSideTree(root,right);
        left.addAll(leaf);
        left.addAll(right);
        left.add(0,root.val);
        return left;
    }
    
    private void leftSideTree(TreeNode root, List<Integer> res)
    {
           
            TreeNode cur =root.left;
        
             while(cur!=null)
             {
                 if(!isleaf(cur))
                     res.add(cur.val);
                 if(cur.left!=null)
                     cur=cur.left;
                 else
                     cur=cur.right;
             }
    }
    
    private void getLeafs(TreeNode root, List<Integer> res)
    {
           if(root==null)
               return;
        
           if(root.left==null && root.right==null)
           {
               res.add(root.val);
               return;
           }
        
           getLeafs(root.left,res);
           getLeafs(root.right,res);
    }
    
     private void rightSideTree(TreeNode root, List<Integer> res)
    {
           
           TreeNode cur =root.right;
        
             while(cur!=null)
             {
                 if(!isleaf(cur))
                     res.add(cur.val);
                 if(cur.right!=null)
                     cur=cur.right;
                 else
                     cur=cur.left;
             }
         
         Collections.reverse(res);
         
         
    }
    
    private boolean isleaf(TreeNode root)
    {
        if(root.left==null && root.right==null)
            return true;
        
        return false;
    }
