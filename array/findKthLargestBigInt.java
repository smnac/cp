package cp.array;

/*
You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.

Return the string that represents the kth largest integer in nums.

Constraints:

1 <= k <= nums.length <= 104
1 <= nums[i].length <= 100
nums[i] consists of only digits.
nums[i] will not have any leading zeros.

*/


import java.util.PriorityQueue;
import java.util.Queue;

class findKthLargestBigInt {
    public String kthLargestNumber(String[] nums, int k) {
        Queue<String> pq=new PriorityQueue<>((x, y) -> {
            if(x.length()==y.length())
                return y.compareTo(x);
            return Integer.compare(y.length(),x.length());
        });
        
        
        for(String num:nums)
            pq.add(num);
        String res=null;
        for(int i=0;i<k;i++){
            res=pq.poll();
           // System.out.println(res);
        }
        return res;
        
    }
}
