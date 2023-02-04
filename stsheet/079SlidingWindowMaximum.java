/*
239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/
*/
//Brute force
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res = new int[n-k+1];
        
        for(int i=0;i<n-k+1;i++)
        {
            int max=nums[i];
            for(int j=i;j<i+k;j++)
                max=Math.max(max,nums[j]);
            res[i]=max;
        }
        
        return res;
    }
}

//priority-Queue

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++)
        {
           
           pq.offer(nums[i]);
            if(i>=k-1)
            {
                res[i-k+1]=pq.peek();
                pq.remove(nums[i-k+1]);
            }
            
        }
        
        return res;
    }
}

//optimal dequeue approach
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
       
        List<Integer> res = new ArrayList<>();
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i<k;i++){
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()])
                queue.pollLast();
            queue.offer(i);
        }
        
        
        
        
        for(int i=k;i<nums.length;i++){
            res.add(nums[queue.peek()]);
            while(!queue.isEmpty() && queue.peek()<=i-k)
                queue.pollFirst();
              while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()])
                queue.pollLast();
            queue.offer(i);
        }
        res.add(nums[queue.peek()]);
        int[] resA = new int[res.size()];

        for(int i=0;i<res.size();i++){
            resA[i] = res.get(i);
        }
        return resA;
    }
}
