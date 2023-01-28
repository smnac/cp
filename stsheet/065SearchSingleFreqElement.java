/*
https://leetcode.com/problems/single-element-in-a-sorted-array/

*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-2; //Imp -2 because xor considers next case
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==nums[mid^1]) //XOR : if mid is even it gives next odd if it is odd it gives previous even
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return nums[low];
        
    }
}
