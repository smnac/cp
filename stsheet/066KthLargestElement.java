/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x)); // make sure to write comparator with y,x -> to reverse sort????
        Queue<Integer> pq = new PriorityQueue<>(); //in this case it will be larger element at bottom of the queue.
        // priority queue is by default min heap.
        // for(int num:nums){
        //     pq.add(num); // when you add array element to pq, it automatically sorts the value based on the comparator, if not provided it will be in decrement order by default???
        // }
        
        // each insertion -> log(n) times, 
        // nlog(n); to insert all n elements.
        
        int res = 0;
        for(int i=0;i<k;i++){
            //System.out.println(pq.peek());
            pq.add(nums[i]);
        }
        
        for(int i=k;i<nums.length;i++){
            //int pqit = pq.peek();
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        
        return pq.poll();
    }
}
