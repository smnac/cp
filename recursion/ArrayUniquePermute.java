package cp.recursion;

/* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUniquePermute {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
     
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
        Set<Integer> considered = new HashSet<>();
        for(int i=l;i<r;i++)
        {
            if(considered.add(nums[i])){ //Check wheter the item is already considered for that level in the decision tree
            swap(nums,i,l);
            helper(nums,l+1,r);
            swap(nums,i,l);
            }
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
