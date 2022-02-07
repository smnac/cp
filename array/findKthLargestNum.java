package cp.array;

import java.util.PriorityQueue;
import java.util.Queue;

class findKthLargestNum {
    public int findKthLargest(int[] nums, int k) {
       Queue<Integer> pq=new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        for(int num:nums)
            pq.add(num);
        int res=0;
        for(int i=0;i<k;i++)
            res=pq.poll();
        return res;
    } 
}
