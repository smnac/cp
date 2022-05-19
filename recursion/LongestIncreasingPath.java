/*

   329. Longest Increasing Path in a Matrix
   Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

*/


class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        int longestPath=Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                int path=dfs(matrix,i,j,m,n,dp);
                longestPath=Math.max(path,longestPath);
            }  
        
        return longestPath;
        
    }
    
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
   int dfs(int[][] matrix,int row,int col,int m,int n,int[][] dp)
   {
       if(dp[row][col]>0)
           return dp[row][col];
       int val=0;
       
       for(int i=0;i<4;i++)
       {
           int rownew=row+dir[i][0];
           int colnew=col+dir[i][1];
           
           if(rownew>=0 && rownew<m && colnew>=0 && colnew<n && matrix[row][col]<matrix[rownew][colnew])
               val = Math.max(val,dfs(matrix,rownew,colnew,m,n,dp));
       }
       dp[row][col]=val+1;
       return val+1;
       
   }
}
