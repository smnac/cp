/*
1254. Number of Closed Islands
https://leetcode.com/problems/number-of-closed-islands/
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
*/

class Solution {
    public int closedIsland(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0;i<m;i++)
        {
            if(grid[i][0]==0)
                dfs(i,0,grid);
            if(grid[i][n-1]==0)
                dfs(i,n-1,grid);
        }
        
         for(int i=0;i<n;i++)
        {
            if(grid[0][i]==0)
                dfs(i,0,grid);
            if(grid[m-1][i]==0)
                dfs(i,n-1,grid);
        }
        
        int count=0;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                if(grid[i][j]==0)
                {
                    if(dfs(i,j,grid))
                    count++;
                }
                
            }
        }
        
        return count;
        
    }
    
    private boolean dfs(int row,int col,int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        
        
        if(row<0 || row>=m || col<0 || col>=n)
            return false;
        
        if(grid[row][col]==1)
            return true;
        
        grid[row][col]=1;
        
         return dfs(row+1,col,grid) & dfs(row-1,col,grid)&dfs(row,col+1,grid)&dfs(row,col-1,grid); //all the four directions should be enclosed with 1
        
        
    }
}
