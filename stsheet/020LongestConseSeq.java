/*

128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        
        int maxStreak = 0;
        for(int key : hs){
            if(!hs.contains(key-1)){ // this is to make sure that the first occurance of the sequence is used, start from smallest number in the consecutive sequence.
                
                int curNum = key;
                int currentStreak = 1;
                
                while(hs.contains(curNum+1)){
                    curNum = curNum+1;
                    currentStreak+=1;
                }
                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }
        
        return maxStreak;
    }
}
