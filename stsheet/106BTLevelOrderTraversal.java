
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


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        boolean is_left=true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            LinkedList<Integer> ans = new LinkedList<>();
            while(size>0){
                size--;
            TreeNode cur = queue.poll();
                if(is_left)
                ans.addLast(cur.val); //imp, add to tail
                else
                ans.addFirst(cur.val); //imp,add to head
                
            if(cur.left != null) 
                queue.offer(cur.left);
                
            if(cur.right != null) 
                queue.offer(cur.right);
            
               
                
        }
            is_left=!is_left; //toggle direction
             res.add(ans);
        
        
    }
        return res;
        
    }
}
