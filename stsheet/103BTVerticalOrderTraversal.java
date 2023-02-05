/*

https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
987. Vertical Order Traversal of a Binary Tree

*/
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> ans = new TreeMap<>();
        
        helper(root,0,0,ans);
        int count=0;
        for(TreeMap<Integer, PriorityQueue<Integer>> tm:ans.values())
        {
            res.add(new ArrayList<>());
            
            for(PriorityQueue<Integer> nodes : tm.values())
            {
                while(!nodes.isEmpty())
                {
                    res.get(count).add(nodes.poll());
                }
            }
            count++;
        }
        
        return res;
        
    }
    
    private void helper(TreeNode root, int level,int hd, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> ans)
    {
        if(root==null)
            return;
        
          ans.putIfAbsent(hd,new TreeMap<Integer, PriorityQueue<Integer>>());
          TreeMap<Integer, PriorityQueue<Integer>> tm = ans.get(hd);
          tm.putIfAbsent(level, new PriorityQueue<>());
          PriorityQueue<Integer> pq = tm.get(level);
          pq.offer(root.val);
        
          helper(root.left,level+1,hd-1,ans);
          helper(root.right,level+1,hd+1,ans);   
        
    }
}
