/*
https://leetcode.com/problems/lru-cache/

*/

class LRUCache {
    
    class Node 
    {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node ()
        {
            prev=null;
            next=null;
        }
        
        public Node(int k,int v)
        {
            key=k;
            val=v;
            prev=null;
            next=null;
        }
        
    }
Node head,tail;
HashMap<Integer,Node> hm;
int cap=0;
    public void deleteNode(Node cur)
    {
        Node prev=cur.prev;
        Node next=cur.next;
        prev.next=next;
        next.prev=prev;
    }
    
    public void insertFront(Node cur)
    {
        cur.next=head.next;
        head.next.prev=cur;
        head.next=cur;
        cur.prev=head;
    }
    public LRUCache(int capacity) {
        head= new Node();
        tail = new Node();
        head.next=tail;
        tail.prev=head;
        hm=new HashMap<>(capacity);
        cap=capacity;
    }
    
    public int get(int key) {
        
        if(hm.containsKey(key))
        {
            Node cur = hm.get(key);
            deleteNode(cur);
            insertFront(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key))
        {
            Node cur = hm.get(key);
            deleteNode(cur);
            cur.val=value;
            insertFront(cur);
            return;
        }
        
        if(hm.size()==cap)
        {
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
            
   
        }
        Node cur = new Node(key,value);
        hm.put(key,cur); 
        insertFront(cur);
        return;
        
        
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
