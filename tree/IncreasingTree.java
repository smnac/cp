
/*Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.*/



public class IncreasingTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	TreeNode cur,newroot;
    public TreeNode increasingBST(TreeNode root) {
              cur=new TreeNode();
              newroot=cur;
               generateTree(root);
        return newroot.right;
        
    }
    
    public void generateTree(TreeNode root)
    {
        
        if(root==null)
            return;
        
        generateTree(root.left);
        root.left=null;
        cur.right=root;
        cur=root;
         generateTree(root.right);
        
            
        
    }

}
