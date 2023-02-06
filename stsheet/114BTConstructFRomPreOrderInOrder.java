class Solution {
    int pi = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int st, int end){
        if(st>end){
            return null;
        }
        if(pi>=preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pi]);
        pi++; // keep incrementing the pri-order array index.
        
        int pivot = findPosition(root.val, inorder);
        
        root.left = helper(preorder, inorder, st, pivot-1);
        root.right = helper(preorder, inorder, pivot+1, end);
        return root;
    }
    
    private int findPosition(int rootVal, int[] inorder){
        
        for(int i=0; i<inorder.length;i++){
            if(inorder[i]==rootVal){
                return i;
            }
        }
        return -1;
    }
}

//Inorder postorder

class Solution {
    int pi; // in the post-order array, the index of the root node.

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length-1;
        return helper(inorder, postorder, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int st, int end){
        if(st>end){
            return null;
        }
        if(pi<0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pi]);
        pi--; // keep decrementing the pri-order array index.
        
        int pivot = findPosition(root.val, inorder);
        
        
        //System.out.println(root.val);
        root.right = helper(inorder, postorder, pivot+1, end);
        root.left = helper(inorder, postorder, st, pivot-1);
        return root;
    }
    
    private int findPosition(int rootVal, int[] inorder){
        
        for(int i=0; i<inorder.length;i++){
            if(inorder[i]==rootVal){
                return i;
            }
        }
        return -1;
    }
}
