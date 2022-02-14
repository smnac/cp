package cp.tree;

public class TreeConstruction1 {
    private int pp; //postorder pointer
     
       
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        
        pp=inorder.length-1;
        return constructTree(inorder,postorder,0,inorder.length-1);   
        
    }
    
    private TreeNode constructTree(int[] inorder,int[] postorder,int start,int end)
    {
        if(start>end || pp<0) 
            return null;
        TreeNode root = new TreeNode(postorder[pp--]);
        int cur=findInorderPos(inorder,root.val);
        root.right=constructTree(inorder,postorder,cur+1,end);
        root.left=constructTree(inorder,postorder,start,cur-1);
       
        return root;
    }
    
    private int findInorderPos(int[] inorder,int val)
    {
        for(int i=inorder.length-1;i>=0;i--)
            if(inorder[i]==val)
                return i;
        return -1;
    }
}
