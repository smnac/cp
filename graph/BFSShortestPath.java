package cp.graph;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/


import java.util.LinkedList;
import java.util.Queue;

public class BFSShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int sx=0,sy=0,dx=grid.length-1,dy=grid[0].length-1;
        int m=grid.length,n=grid[0].length;
        if(grid[sx][sy]!=0 || grid[dx][dy]!=0)
            return -1;
        Queue<Point> queue = new LinkedList<>();
       // boolean[][] visited = new boolean[m][n];
        queue.add(new Point(sx,sy));
    //    visited[sx][sy]=true;
        grid[sx][sy]=1; //instead of visited just update processed cell with distance
        
        while(!queue.isEmpty())
        {
            Point p = queue.poll();
            int x=p.x;
            int y=p.y;
            
            int distance=grid[x][y];
            if(x==dx && y==dy)
                return distance;
           
            int[][] directions = 
        new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; //all eight direction cells
            for(int[] direction:directions)
            {
                int xnew=x+direction[0];
              int ynew=y+direction[1];
                if(xnew >=0 && xnew < m && ynew>=0 && ynew < n && grid[xnew][ynew]==0 /*&& !visited[xnew][ynew]*/)
                {
                    //System.out.println("hello");
                    queue.add(new Point(xnew,ynew));
                  //  visited[xnew][ynew]=true;
                    grid[xnew][ynew]=distance+1;
                }
            }
            
        }
        
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
