package cp.tree;

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
public class TreeRecursionProblems {
//top down approach
private int answer; // don't forget to initialize answer before call maximum_depth
private void maximum_depth(TreeNode root, int depth) {
    if (root == null) {
        return;
    }
    if (root.left == null && root.right == null) {
        answer = Math.max(answer, depth);
    }
    maximum_depth(root.left, depth + 1);
    maximum_depth(root.right, depth + 1);
}
//Bottom-up approach
public int maximum_depth(TreeNode root) {
    if (root == null) {
        return 0;                                   // return 0 for null node
    }
    int left_depth = maximum_depth(root.left);
    int right_depth = maximum_depth(root.right);
    return Math.max(left_depth, right_depth) + 1;   // return depth of the subtree rooted at root
}
//Recursive
public boolean isSymmetric(TreeNode root) {
    return isMirror(root,root);
    
}

private boolean isMirror(TreeNode t1,TreeNode t2)
{
    if(t1==null && t2==null)
        return true;
    if(t1==null || t2==null)
        return false;
    return (t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
}

//Iterative using queue

public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)return true;
        Queue<TreeNode>q=new LinkedList();  
        q.add(root);
        
        TreeNode nullNode=new TreeNode(Integer.MAX_VALUE);
        q.add(nullNode);
        
        while(q.size()>1)
        {
            ArrayList<Integer>arr=new ArrayList<>();
            
            while(q.peek()!=nullNode)
            {
                TreeNode node=q.remove();
                if(node.left!=null)
                {
                    q.add(node.left);
                    arr.add(node.left.val);
                }
                else
                    arr.add(-1);
                if(node.right!=null)
                {
                    q.add(node.right);
                    arr.add(node.right.val);
                }
                else
                    arr.add(-1);
            }
            
            TreeNode node=q.remove();
            q.add(nullNode);
            
            boolean cout=ispall(arr);
            if(!cout)return false;
        }
        return true;
    }
    public static boolean ispall(ArrayList<Integer>arr)
    {
        int n=arr.size();
        int i=0;
        int j=n-1;
        while(i<=j)
        {
            if(arr.get(i)!=arr.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            if(targetSum-root.val==0)
                return true;
    
         return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    
    
    
    }

    public int countUnivalSubtrees(TreeNode root) {
        int[] counter = new int[1];
        dfs(root,counter);
        return counter[0];
    }
    
    public void dfs(TreeNode root,int[] counter)
    {
        if(root==null)
            return;
        
        if(univalued(root,root.val))
            counter[0]++;
        
        dfs(root.left,counter);
        dfs(root.right,counter);
    }
    
    private boolean univalued(TreeNode root, int passedValue)
    {
        if(root==null)
            return true;
        if(root.val!=passedValue)
            return false;
        return univalued(root.left,passedValue) && univalued(root.right,passedValue);
    }

}


