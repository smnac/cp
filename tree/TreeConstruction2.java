package cp.tree;

public class TreeConstruction2 {

    private int pp=0; //preorder pointer
    private int len;
       
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        len=inorder.length;
        return constructTree(inorder,preorder,0,inorder.length-1);   
        
    }
    
    private TreeNode constructTree(int[] inorder,int[] preorder,int start,int end)
    {
        if(start>end || pp>len-1) 
            return null;
        TreeNode root = new TreeNode(preorder[pp++]);
        int cur=findInorderPos(inorder,root.val);
         root.left=constructTree(inorder,preorder,start,cur-1);
        root.right=constructTree(inorder,preorder,cur+1,end);
       
        
       
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
