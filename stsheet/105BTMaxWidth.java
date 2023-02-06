/*
https://leetcode.com/problems/maximum-width-of-binary-tree/
662. Maximum Width of Binary Tree

*/
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        queue.offer(root);
        
        int maxWidth = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int k=queue.size();
            
            List<Integer> level = new ArrayList<>();
            while(size>0){
                TreeNode node = queue.poll();
                
                // for the first time
                if(size == k){  //size == queue.size() danger don't do
                    left = map.get(node);
                    
                }
                //for the last time.
                if(size == 1){
                    right = map.get(node);
                   
                }
                
                
                //level.add(node.val);

                if(node.left != null){
                    map.put(node.left, map.get(node)*2);
                    queue.offer(node.left);
                } 
                if(node.right != null){
                    map.put(node.right, map.get(node)*2+1);
                    queue.offer(node.right);
                } 
                
                size--;

            }
            
            maxWidth = Math.max(maxWidth, right-left+1);
        }
        return maxWidth;
    }
    
}
