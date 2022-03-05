import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, invert the tree, and return its root.*/

public class InvertBinaryTree {
	
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
	public TreeNode invertTree(TreeNode root) {
	/* Recursion     
	   if(root==null)
	            return null;
	        TreeNode right=invertTree(root.right);
	        TreeNode left=invertTree(root.left);
	        root.left=right;
	        root.right=left;
	        return root; */
	        
	         if (root == null) return null;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            TreeNode current = queue.poll();
	            TreeNode temp = current.left;
	            current.left = current.right;
	            current.right = temp;
	            if (current.left != null) queue.add(current.left);
	            if (current.right != null) queue.add(current.right);
	        }
	        return root;
	    
	        
	    }

}
