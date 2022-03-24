class LRUCache {

	class Node {
		int key;
		int val;
		Node prev;
		Node next;
	}

	final Node head = new Node();
	final Node tail = new Node();

	Map<Integer, Node> map;

	int cache_capacity;

	public LRUCache(int capacity) {
		
		map=new HashMap<>(capacity);
		cache_capacity=capacity;
		head.next=tail;
		tail.prev=head;
		
		

	}

	public int get(int key) {
		int result=-1;
		Node node = map.get(key);
		if(node!=null)
		{
			result=node.val;
			remove(node);
			add(node);
		}
				
		return result;
		

	}

	public void put(int key, int value) {
		
		Node node = map.get(key);
		if(node!=null)
		{
			node.val=value;
			remove(node);
			add(node);
		}else {
		if(map.size()== cache_capacity) {
			map.remove(tail.prev.key);
			remove(tail.prev);
		}
		node=new Node();
		node.key=key;
		node.val=value;
		add(node);
		map.put(key, node);
		}
	}
	
	public void add(Node node)
	{
		node.next=head.next;
		node.next.prev=node;
		node.prev=head;
		head.next=node;
		
	}
	
	public void remove(Node node)
	{
		node.prev.next=node.next;
		node.next.prev=node.prev;
		
		
	}
	

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
