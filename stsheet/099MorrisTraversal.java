class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        
        
    TreeNode cur=root;
        
        while(cur!=null)
        {
            if(cur.left==null)
            {
                inorder.add(cur.val);
                cur=cur.right;
            }
            else
            {
                TreeNode prev = cur.left;
                
                while(prev.right!=null && prev.right!=cur)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=cur;
                    //for preorder store/print here, this is while marking the thread and remove from below else
                    cur=cur.left;
                }
                else
                {
                    prev.right=null;
                    inorder.add(cur.val);
                    cur=cur.right;
                }
            }
          
        }
        return inorder;
        
    }
}
