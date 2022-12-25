/*


62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100

*/
//dp solution
class Solution {
    public int uniquePaths(int m, int n) {
        boolean[][] grid = new boolean[m][n];
        int[][] dp = new int[m][n];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return helper(grid,0,0,m,n,dp);
        
    }
    
    private int helper(boolean[][] grid,int row,int col,int m,int n,int[][] dp)
    {
        if(row>=m || col>=n)
            return 0;
        
        if(row==m-1 && col==n-1)
            return 1;
        
        if(dp[row][col]!=-1)
            return dp[row][col];
        
        int right=helper(grid,row,col+1,m,n,dp);
        int down = helper(grid,row+1,col,m,n,dp);
        return dp[row][col]=right + down;
    }
}


//combinatoric solution we know max it is m+n-2, how many ways we can take horizonal or vertical steps
// m+n-2Cm-1 or m+n-2Cn-1



class Solution {
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int r = m - 1; 
        double res = 1;
            
        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;
        
        return (int)res;
    }
}
