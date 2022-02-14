package cp.graph;

/*

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

*/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangeBFS {
    public int orangesRotting(int[][] grid) {
        
        int m=grid.length, n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Queue<Point> queue = new LinkedList<>();
        boolean hasRotten = false,hasFresh=false;
        int freshCount=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                {
                    hasRotten=true;
                    queue.add(new Point(i,j));
                    visited[i][j]=true;
                }
                
                if(grid[i][j]==1){
                    hasFresh=true;
                    freshCount++;
                }
            }
        
         int elapsed=0;
        if(!hasRotten && hasFresh )
            return -1;
        if(hasRotten && !hasFresh )
            return elapsed;
        if(!hasRotten && !hasFresh)
            return elapsed;
       
        int qc=queue.size();
        while(true)
        {
            qc=queue.size();
            if(qc==0)
                break;
            
            
            
            while(qc>0) {
            Point p = queue.poll();
            int x=p.x;
            int y=p.y;
            //if(freshCount==0)
           //     return elapsed;
            qc--;
            int[][] directions = 
        new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            
            for(int[] direction:directions)
            {
                int xnew=x+direction[0];
              int ynew=y+direction[1];
                if(xnew >=0 && xnew < m && ynew>=0 && ynew < n && grid[xnew][ynew]==1 &&!visited[xnew][ynew] )
                {
                    visited[xnew][ynew]=true;
                    queue.add(new Point(xnew,ynew));
                    grid[xnew][ynew]=2;
                    freshCount--;
                    
                }
            }
            }
             elapsed++;
            if(freshCount==0)
                return elapsed;
        }
            
           
            
        
        
        if(freshCount==0)
            return elapsed;
        return -1;
            
        
    }
    
    class Point
    {
        int x;
        int y;
        
        Point(int a,int b)
        {
            x=a;
            y=b;
        }
    } 
}
