/*
https://leetcode.com/problems/3sum/
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
            int low = i+1; // start boundary
            int high=nums.length-1; //end boundary
            int target=0-nums[i];  //target
            //repeat two sum program
            while(low<high)
            {
                
                if(nums[low]+nums[high]==target)
                {
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    //just skip duplicates
                    while(low<high && nums[low]==nums[low+1]) low++;   
                    //just skip duplicates
                    while(low<high && nums[high]==nums[high-1]) high--;
                    //procede normally
                    low++;
                    high--;
                }
                else if(nums[low]+nums[high]<target)
                {
                    low++;
                }
                else
                {
                    high--;
                }
            }
         }
        }
        return res;
    }
}
