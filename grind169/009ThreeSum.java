/*
15. 3Sum
https://leetcode.com/problems/3sum/
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++)   //imp length-2
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){ //skip repeating element
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


/*

259. 3Sum Smaller


https://leetcode.com/problems/3sum-smaller/

Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 

Example 1:

Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]
Example 2:

Input: nums = [], target = 0
Output: 0
Example 3:

Input: nums = [0], target = 0
Output: 0
 

Constraints:

n == nums.length
0 <= n <= 3500
-100 <= nums[i] <= 100
-100 <= target <= 100
*/

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length-2;i++)
        {
            int low=i+1;
            int high=nums.length-1;
            int targetForTwoSum = target-nums[i];
            
            while(low<high)
            {
                if(nums[low]+nums[high]<targetForTwoSum){
                    res+=high-low;   //Trick directly we will get count
                    low++;
                }
                else
                {
                    high--;
                }
                
                    
            }
        }
        return res;
    }
}


/*

16. 3Sum Closest

https://leetcode.com/problems/3sum-closest/

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104

*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
       for(int i=0;i<nums.length-2;i++)
       {
           int low=i+1;
           int high=nums.length-1;
           while(low<high)
           {
               int sum=nums[i]+nums[low]+nums[high];
               if(Math.abs(target-sum)<Math.abs(diff)) // diff comp is abs
                   diff=target-sum;   //need to store actual diff
                 if(diff==0)
                     break;
               
               if(sum<target)
                   low++;
               else
                   high--;
           }
           
          if(diff==0)
              break;
       }
        
         return target-diff;
        
    }
}
