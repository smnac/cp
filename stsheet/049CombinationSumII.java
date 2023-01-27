/*
https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
     if(candidates == null)
            return null;
        
        res=new ArrayList<>();
        
        helper(candidates,0,candidates.length,target,new ArrayList<Integer>());
        
        return res;
    }
    
  void helper(int[] arr,int index,int N,int target, ArrayList<Integer> cur)
  {
      if(target==0)
      {
          res.add(new ArrayList<>(cur));
          return;
          
      }
      
      for(int i=index;i<N;i++)
      {
          if(i>index && arr[i-1]==arr[i])
              continue;
          if(arr[i]>target)
              break;
          cur.add(arr[i]);
          helper(arr,i+1,N,target-arr[i],cur);
          cur.remove(cur.size()-1);
      }
      
  }
}
