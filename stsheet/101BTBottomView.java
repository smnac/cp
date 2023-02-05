/*
https://www.codingninjas.com/codestudio/problems/893110?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
Bottom View Of Binary Tree

*/

public class Solution {
     static class Pair
    {
        BinaryTreeNode node;
        int hd;
        public Pair(BinaryTreeNode n,int h)
        {
            node=n;
            hd=h;
        }
     }
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
      Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        
        queue.offer(new Pair(root,0));
        
        
        while(!queue.isEmpty())
        {
            Pair cur = queue.poll();
            int hd=cur.hd;
            BinaryTreeNode node=cur.node;
            tm.put(hd,node.val);
            
            if(node.left!=null)
                queue.offer(new Pair(node.left,hd-1));
            if(node.right!=null)
                queue.offer(new Pair(node.right,hd+1));
        }
        
        for(int p:tm.values())
            res.add(p);
        
        return res;      
    }
}