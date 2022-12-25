/*
229. Majority Element II

https://leetcode.com/problems/majority-element-ii/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?

*/

//imp: Boyer-Moore Voting Algorithm similar to majority element but don't forget if,else if :)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Integer element1=null;
        Integer element2=null;
        int count1=0;
        int count2=0;
        
        for(int num:nums)
        {
            if(element1!=null && element1==num)
            {
                count1++;
            }
            else if(element2!=null && element2==num)
            {
                count2++;
            }
            else if(count1==0)
            {
                element1=num;
                count1=1;
            }
            else if(count2==0)
            {
                element2=num;
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        
        for(int num:nums)
        {
            if(num==element1)
                count1++;
            else if(num==element2)
                count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(element1!=null && count1 > nums.length/3)
        res.add(element1);
        if(element2!=null && count2 > nums.length/3)
        res.add(element2);
        return res;
        
    }
}
