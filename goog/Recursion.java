import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,1};
		//printSubSequenceWithSum(arr,0,arr.length,new ArrayList<>(),0,4);
		System.out.println(countSubSeq(arr,0,arr.length,0,2));
	}
	
	
	
	/* consider and not consider / taken or not taken pattern 
	 * Don't forget to do the backtracking
	 */
		private static void printAllSubSequenceWithSum(int[] arr, int start, int end, ArrayList<Integer> res, int sumsofar, int target) {
			
	        if(start==end)
	        {
	        	if(sumsofar==target)
	        	{
	        		System.out.println(res);
	        		
	        	}
	        	return;
	        }
	        /*consider case */
	        res.add(arr[start]);
	        sumsofar=sumsofar+arr[start];
	        printSubSequenceWithSum(arr,start+1,end,res,sumsofar,target);
	        
	        /*not consider case */
	        res.remove(res.size()-1);
	        sumsofar=sumsofar-arr[start];
	        printSubSequenceWithSum(arr,start+1,end,res,sumsofar,target);
	        
		}
		
		
	
	/* Important counting number of ways 
	 * return 1 and return 0
	 * return cumulative sum of all the recursive call output
	 * 
	 * */
	
private static int countSubSeq(int[] arr, int start, int end, int sumsofar, int target) {
		
	         if(start==end)
	         {
	        	 if(sumsofar==target)
	        		 return 1;
	        	 else
	        		 return 0;
	         }
	         
	         int count=0;
	         sumsofar+=arr[start];
	         count+=countSubSeq(arr,start+1,end,sumsofar,target);
	         sumsofar-=arr[start];
	         count+=countSubSeq(arr,start+1,end,sumsofar,target);
	         return count;
	}




	
	
	/* How to come out of recursion as soon as you find one answer
	 * -> return boolean and try to catch it in subsequent recursive calls
	 * base condition should return true and false
	 * function call should be check for the true
	 * at the end return false
	 */
	
  private static boolean printSubSequenceWithSum(int[] arr, int start, int end, ArrayList<Integer> res, int sumsofar, int target) {
		
        if(start==end)
        {
        	if(sumsofar==target)
        	{
        		System.out.println(res);
        		return true;   // Important1
        		
        	}
        	return false;    //Important2
        }
        /*consider case */
        res.add(arr[start]);
        sumsofar=sumsofar+arr[start];
        if(printSubSequenceWithSum(arr,start+1,end,res,sumsofar,target)==true)
        	return true;     //Important3
        
        /*not consider case */
        res.remove(res.size()-1);
        sumsofar=sumsofar-arr[start];
        if(printSubSequenceWithSum(arr,start+1,end,res,sumsofar,target)==true)
        	return true; //Important5
        return false;    //Important6
        
	}
  
  
  
  
  // 39. Combination Sum
  
  /*
   * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
   * 
   */
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      
      List<List<Integer>> ans = new ArrayList<>();
      helper(candidates,0,candidates.length,target,new ArrayList<Integer>(),ans);
      return ans;
      
  }
  
  private void helper(int[] candidates,int start,int end, int target,List<Integer> cur,List<List<Integer>> ans)
  {
      if(start>=end)
          return;
      
       if(target==0){
              ans.add(new ArrayList<>(cur));
          return;
       }
      
      
      if(target-candidates[start]>=0)
      {
          cur.add(candidates[start]);
          helper(candidates,start,end,target-candidates[start],cur,ans);
          cur.remove(cur.size()-1);
      }
      helper(candidates,start+1,end,target,cur,ans);
  }
  
  
  
  
  
  
// 40. Combination Sum II
  /*
   * Given a collection of candidate numbers (candidates) and a target number (target),
   *  find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]





   */
  
  
	    List<List<Integer>> res;
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        Arrays.sort(candidates);
	     if(candidates == null)
	            return null;
	        
	        res=new ArrayList<>();
	        
	        helper(candidates,0,candidates.length,target,new ArrayList<Integer>());
	        
	        return res;
	    }
	    
	    void helper(int[] candidates,int start,int end,int target,List<Integer> cur)
	    {
	        if(target==0){
	            res.add(new ArrayList<>(cur)); // create new list and add to result
	            return;
	        }
	        //either for loop or two recursive method with consider / not consider
	        
	        for(int i=start;i<end;i++)
	        {
	            if(i > start && candidates[i] == candidates[i-1]) continue; // very important
	            if(candidates[i]>target)
	                break;
	            
	                cur.add(candidates[i]);
	                helper(candidates,i+1,end,target-candidates[i],cur);
	                cur.remove(cur.size()-1); //Remove actual element and not the index
	        }
	    }
	

}
