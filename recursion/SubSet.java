package cp.recursion;


/*

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

*/
import java.util.ArrayList;
import java.util.List;

public class SubSet {
     
    /*
    
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    int n = nums.length;

    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1') curr.add(nums[j]);
      }
      output.add(curr);
    }
    return output;
  }
  */
  List<List<Integer>> res=new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums) {
      if(nums.length==0)
          return res;
      helper(nums,0,nums.length,new ArrayList<>());
      return res;
  }
  
  void helper(int[] nums,int start,int end,List<Integer> cur)
  {
      res.add(new ArrayList<>(cur));
      for(int i=start;i<end;i++)
      {
          cur.add(nums[i]);
          helper(nums,i+1,end,cur);
          cur.remove(cur.size()-1);
      }
  }
}
