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


// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
