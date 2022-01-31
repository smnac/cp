package cp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 

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
 
public class TreeTraversals {
    List<Integer> res=new ArrayList<Integer>();
    //Recursive
   /* public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return res;
        else{
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        }
        return res;
        
    }*/
    //Using stack
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            res.add(node.val);
  
            if(node.right!=null)
             stack.push(node.right);
            if(node.left!=null)
             stack.push(node.left);
        }
        
        
        return res;
    }

    /* public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
            return res;
        else{
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        }
        return res;
        
    }*/
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
            return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty())
        {
            while(cur!=null)
            {
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
            
        }
        
        return res;
    }

    /* public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return res;
        else
        {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
            
        }
        return res;
        
    }*/
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return res;
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            stack1.push(root);
            while(!stack1.isEmpty())
            {
                TreeNode cur=stack1.pop();
                stack2.push(cur);
                if(cur.left!=null)
                    stack1.push(cur.left);
                if(cur.right!=null)
                    stack1.push(cur.right);
                
            }
            while(!stack2.isEmpty())
            {
                res.add(stack2.pop().val);
            }
            return res;
            
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            
            queue.add(root);
            while(!queue.isEmpty())
            {
                List<Integer> level = new ArrayList<>();
                int l = queue.size();
                for(int i=0;i<l;i++){
                TreeNode node = queue.poll();
                    if(node!=null){
                        level.add(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                    
                }
                if(!level.isEmpty())
                    res.add(level);
            }
            return res;
            
        }

}
