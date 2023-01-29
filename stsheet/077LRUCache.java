/*
https://leetcode.com/problems/lru-cache/

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
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
