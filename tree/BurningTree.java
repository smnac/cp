/*

https://practice.geeksforgeeks.org/problems/burning-tree/1
Given a binary tree and a node called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.

*/

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        Map<Node,Node> hm = new HashMap<>();
        Node x=null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            Node cur = queue.poll();
            if(cur.data==target)
               x=cur;
            if(cur.left!=null)
            {
                queue.offer(cur.left);
                hm.put(cur.left,cur);
            }
            if(cur.right!=null)
            {
                queue.offer(cur.right);
                hm.put(cur.right,cur);
            }
        }
        
        
        Map<Node,Integer> visited = new HashMap<>();
        queue.offer(x);
        visited.put(x,1);
        
        int level=0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            boolean flag=false;
            while(size>0){
                Node cur = queue.poll();
                
                if(cur.left!=null && visited.get(cur.left)==null)
                {
                    queue.offer(cur.left);
                    visited.put(cur.left,1);
                    flag=true;
                }
                
                if(cur.right!=null && visited.get(cur.right)==null)
                {
                    queue.offer(cur.right);
                    visited.put(cur.right,1);
                     flag=true;
                }
                
                if(hm.get(cur)!=null && visited.get(hm.get(cur))==null)
                {
                    queue.offer(hm.get(cur));
                    visited.put(hm.get(cur),1);
                     flag=true;
                }
               // System.out.println("this de :"+cur.data);
                size--;
            }
             if(flag==true)
            level++;
            
            
        }
        
        return level;
    }
}
