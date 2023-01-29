/*
https://leetcode.com/problems/lfu-cache/

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Constraints:

0 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
*/

class LFUCache {
    int maxCapacity;
    int curSize;
    int minFreq;
    Map<Integer,Node> cache;
    Map<Integer,DoubleLinkedList> freqListMap;
     public LFUCache(int capacity) {
         maxCapacity=capacity;
         curSize=0;
         minFreq=0;
         cache=new HashMap<>();
         freqListMap=new HashMap<>();
        
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node==null)
            return -1;
        updateNodeFreq(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(maxCapacity==0)
            return;
        if(cache.containsKey(key))
        {
            Node node=cache.get(key);
            node.val=value;
            updateNodeFreq(node);
        }
        else
        {
            curSize++;
            if(curSize > maxCapacity)
            {
                DoubleLinkedList minFreqList = freqListMap.get(minFreq); 
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                 curSize--;
            }
            minFreq=1;
            Node node = new Node(key,value);
              DoubleLinkedList curFreqList=freqListMap.getOrDefault(1,new DoubleLinkedList());
            curFreqList.addNode(node);
            freqListMap.put(1,curFreqList);
            cache.put(key,node);
            
        }
        
    }
    
    public void updateNodeFreq(Node node)
    {
        int curFreq = node.freq;
        DoubleLinkedList curFreqList = freqListMap.get(curFreq);
        curFreqList.removeNode(node);
        
        if(curFreq==minFreq && curFreqList.size==0)
            minFreq++;
        node.freq=node.freq+1;
        
        DoubleLinkedList newFreqList=freqListMap.getOrDefault(node.freq,new DoubleLinkedList());
        newFreqList.addNode(node);
        freqListMap.put(node.freq,newFreqList);
        
    }
    
    
    class Node
    {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        public Node()
        {
            
        }
        public Node(int k,int v)
        {
            key=k;
            val=v;
            freq=1;
        }
    }
    
    class DoubleLinkedList
    {
        int size;
        Node head;
        Node tail;
        
        public DoubleLinkedList()
        {
            size=0;
            head=new Node();
            tail=new Node();
            head.next=tail;
            tail.prev=head;
        }
        
        public void addNode(Node node)
        {
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
            size++;
        }
        
          public void removeNode(Node node)
        {
            node.next.prev=node.prev;
            node.prev.next=node.next;
              size--;
        }
        
        
    }

   
}
