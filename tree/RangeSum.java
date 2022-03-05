import java.util.Stack;

/*Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
		Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
		Output: 32
		Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.*/


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


public class RangeSum {
	
	int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root,low,high);
        return sum;
        
    }
    
    void inorder(TreeNode root,int low,int high)
    {
        if(root==null)
            return;
       
        if(root.val>=low)
        inorder(root.left,low,high);
        if(root.val>=low && root.val<=high)
         sum=sum+root.val;
        if(root.val<=high)
        inorder(root.right,low,high);
        
    }
    
    
   void inorderStack(TreeNode root,int low,int high)
   {
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);
       while(!stack.isEmpty())
       {
           TreeNode node = stack.pop();
           if(node!=null)
           {
               if(node.val>=low && node.val<=high)
                   sum+=node.val;
               if(node.val>=low)
               stack.push(node.left);
               if(node.val<=high)
               stack.push(node.right);
               
           }
       }
       
   }
    

}
