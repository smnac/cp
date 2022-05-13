package cp.tree;

/*
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be 
set to NULL.

Initially, all next pointers are set to NULL.
*/

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right,Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next= next;
    }
}


public class TreeNextPointer {
    
     public Node connectBFS(Node root) {
         if(root==null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Node dummy = new Node();
            while(size>0)
            {
                Node cur=queue.poll();
                size--;
                dummy.next=cur;
                dummy=dummy.next;
                
                if(cur.left!=null)
                    queue.offer(cur.left);
                
                if(cur.right!=null)
                   queue.offer(cur.right);
                
                
            }
        }
        return root;
    }
    
    public Node connect(Node root) {
        if(root==null)
            return null;
        Node cur=root;
        
        while(cur!=null)
        {
            Node dummy=new Node();
            Node temp=dummy;
            
            while(cur!=null)
            {
                if(cur.left!=null)
                {
                    temp.next=cur.left;
                    temp=temp.next;
                    
                }
                
                if(cur.right!=null)
                {
                    temp.next=cur.right;
                    temp=temp.next;
                }
                
                cur=cur.next;
            }
            cur=dummy.next;
        }
        
        return root;
        
    }
}
