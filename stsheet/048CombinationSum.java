/*

https://leetcode.com/problems/combination-sum/

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,0,candidates.length,target,new ArrayList<Integer>(),ans);
        return ans;
        
    }
    
    private void helper(int[] arr,int index,int N,int target,List<Integer> cur,List<List<Integer>> ans)
    {
        
        if(index==N)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        
        if(arr[index]<=target)
        {
            cur.add(arr[index]);
            helper(arr,index,N,target-arr[index],cur,ans); // remember not index+1, again index infinte supply
            cur.remove(cur.size()-1);
        }
        helper(arr,index+1,N,target,cur,ans);
        
    }
    
  
}
