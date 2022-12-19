# 250. Count Univalue Subtrees

class CountUnivaluedTrees {
    int ans=0;
    public int countUnivalSubtrees(TreeNode root) {
        
        dfs(root);
        return ans;
        
    }
    
    void dfs(TreeNode root)
    {
        if(root==null)
            return;
        
        if(univalued(root,root.val)) //inorder traversal for every root.value scan the entire tree
            ans++;
        
        dfs(root.left);
        dfs(root.right);
    }
    
    boolean univalued(TreeNode root, int key)
    {
        if(root==null)
            return true;
        
        if(root.val!=key)
            return false;
        
        return univalued(root.left,key) && univalued(root.right,key);
    }
}
