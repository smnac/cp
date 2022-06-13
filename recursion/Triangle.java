/*
120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
*/


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        
         for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        return helper(triangle,0,0,dp);
        
    }
    
    public int helper(List<List<Integer>> triangle,int row,int col,int[][] dp)
    {
        
        if(row==triangle.size())
            return 0;
        
        if(dp[row][col]!=Integer.MAX_VALUE)
            return dp[row][col];
        
        int curSum = Math.min(helper(triangle,row+1,col,dp),helper(triangle,row+1,col+1,dp));
        
        
        return dp[row][col]=curSum+triangle.get(row).get(col);
    }
}
