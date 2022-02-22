package cp.matrix;

/*
 Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.

The line could be horizontal, vertical, diagonal, or anti-diagonal.

Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
Output: 3

Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
Output: 4

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.

*/

public class LongestLine {
    public int longestLine(int[][] mat) {
        
        if(mat==null || mat.length==0)
            return 0;
         
         int m=mat.length;
         int n=mat[0].length;
         
         int[][][] dp = new int[m+1][n+2][4]; //for all 4 direction length
         
         int maxLength=0;
         
         for(int i=0;i<m;i++)
             for(int j=0;j<n;j++)
             {
                 if(mat[i][j]==1)
                 {
                     dp[i+1][j+1][0]=dp[i][j][0]+1;
                     maxLength=Math.max(dp[i+1][j+1][0],maxLength);
                     
                      dp[i+1][j+1][1]=dp[i+1][j][1]+1;
                     maxLength=Math.max(dp[i+1][j+1][1],maxLength);
                     
                      dp[i+1][j+1][2]=dp[i][j+1][2]+1;
                     maxLength=Math.max(dp[i+1][j+1][2],maxLength);
                     
                      dp[i+1][j+1][3]=dp[i][j+2][3]+1;
                     maxLength=Math.max(dp[i+1][j+1][3],maxLength);
                 }
             }
         
         return maxLength;
         
     }
    
}
