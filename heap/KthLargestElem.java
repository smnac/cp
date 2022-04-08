class KthLargest {
    
    int k;
    Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();
        for(int num:nums)
            pq.offer(num);
        
        while(pq.size()>k)
            pq.poll();
        
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k)
            pq.poll();
        return pq.peek();
    }
}


