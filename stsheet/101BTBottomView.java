/*
https://www.codingninjas.com/codestudio/problems/893110?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
Bottom View Of Binary Tree
Top View Of Binary Tree

 make sure recursion striaghway will not work along with hd we need to consider height

*/
//Bottom view
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

//Top view
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
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
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
            tm.putIfAbsent(hd,node.val);
            
            if(node.left!=null)
                queue.offer(new Pair(node.left,hd-1));
            if(node.right!=null)
                queue.offer(new Pair(node.right,hd+1));
        }
        
        for(int p:tm.values())
            res.add(p);
        
        return res;
	}
 /* Recursion failure : This will not work  
 private static void helper(BinaryTreeNode root, int hd,TreeMap<Integer,Integer> map)
    {
        if(root==null)
            return;
        map.putIfAbsent(hd,root.val);
        helper(root.left,hd-1,map);
        helper(root.right,hd+1,map);
    }
   */ 
}
