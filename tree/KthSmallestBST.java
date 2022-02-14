package cp.tree;

//##### IMPORTANT############
//For Kth Largest N-Kth Smallest, for getting N you need one more traversal

public class KthSmallestBST {
     // ArrayList<Integer> res = new ArrayList<>();
     int count=0;
     public int kthSmallest(TreeNode root, int k) {
        
        // traverse(root);
       //  return res.get(k-1);
         
         int[] ans=new int[1];
         traverse(root,k,ans);
         return ans[0];
         
     }
     
    void traverse(TreeNode root,int k,int[] ans)
     {
         if(root==null)
             return;
         
         traverse(root.left,k,ans);
         count++;
         if(count==k){
             ans[0]=root.val;
             return;
         }
        
         traverse(root.right,k,ans);
     } 
}
