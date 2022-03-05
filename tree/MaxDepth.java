
/*Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
public class MaxDepth {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }


	
	int maxDepth=0;
    public int maxDepth(TreeNode root) {
        
           helper(root,1);
        return maxDepth;
    }
    
    void helper(TreeNode root,int depth)
    {
        if(root==null)
            return;
        
        if(root.left==null && root.right==null)
        maxDepth=maxDepth<depth?depth:maxDepth;
        
        helper(root.left, depth+1);
        helper(root.right,depth+1);
        
    }

}
