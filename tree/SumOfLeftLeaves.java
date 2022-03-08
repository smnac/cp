
public class SumOfLeftLeaves {
	
	int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
            if(root==null)
                return sum;
        
        if(root.left!=null && root.left.left==null && root.left.right==null)
            sum+=root.left.val;
        
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
        
    }

}
