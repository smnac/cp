/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        
        for(int i=1;i<nums.length;i++)
            if(nums[i-1]!=nums[i])
                nums[++idx]=nums[i];
        
        return idx+1;
    }
}
