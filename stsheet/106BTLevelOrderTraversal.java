
/*
102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/

*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ans = new ArrayList<>();
            while(size>0){
                size--;
            TreeNode cur = queue.poll();
            ans.add(cur.val);
            if(cur.left != null) 
                queue.offer(cur.left);
                
            if(cur.right != null) 
                queue.offer(cur.right);
            
               
                
        }
             res.add(ans);
        
        
    }
        return res;
}
    
}
