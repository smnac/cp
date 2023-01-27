/*

https://leetcode.com/problems/permutations/

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
           helper(nums,0,ans);
        return ans;
        
    }
    
    private void helper(int[] nums,int index,List<List<Integer>> ans)
    {
        if(index==nums.length)
        {
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
                res.add(nums[i]);
            ans.add(res);
            return;
        }
        
        for(int i=index;i<nums.length;i++)
        {
            swap(index,i,nums);
            helper(nums,index+1,ans);
            swap(index,i,nums);
        }
        
        
    }
    
    private void swap(int x,int y, int[] nums)
    {
        int temp = nums[x];
            nums[x]=nums[y];
            nums[y] = temp;
        
    }
}
