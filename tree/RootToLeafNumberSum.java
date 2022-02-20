package cp.tree;



class RootToLeafNumberSum {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    //**preorder traversal */
    void helper(TreeNode root, int numSofar)
    {
        if(root!=null)
        {
            
            numSofar=numSofar*10+root.val;
            
            if(root.left==null && root.right==null)
                sum=sum+numSofar;
            helper(root.left,numSofar);
            helper(root.right,numSofar);
            
            
        }
        
        
    }
}
