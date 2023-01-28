/*

https://leetcode.com/problems/top-k-frequent-elements/

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        
        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            pq.add(entry);
        int[] res=new int[k];
        for(int i=0;i<k;i++)
            res[i]=pq.poll().getKey();
        return res;
        
    }
}
