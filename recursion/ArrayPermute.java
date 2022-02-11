package cp.recursion;

/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayPermute {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        
        res = new ArrayList<>();
        
        helper(nums,0,nums.length);
        return res;
        
    }
    
    void helper(int[] nums,int l,int r)
    {
        if(l==r)
        {
            List<Integer> list = new ArrayList<>(nums.length);
 
        for (int i: nums) {
            list.add(i);
        }
            
            res.add(list);
            return;
        }
        
        for(int i=l;i<r;i++)
        {
            swap(nums,i,l);
            helper(nums,l+1,r);
            swap(nums,i,l);
        }
        
    }
    
    
    void swap(int[] nums,int x,int y)
    {
        int temp;
        temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}
