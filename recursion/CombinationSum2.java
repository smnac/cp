package cp.recursion;


/* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

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
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30



*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
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
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i]<=target)
            {
                cur.add(candidates[i]);
                helper(candidates,i+1,end,target-candidates[i],cur);
                cur.remove(cur.size()-1); //Remove actual element and not the index
            }
        }
    }
}
