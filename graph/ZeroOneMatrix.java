/*542. 01 Matrix
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat. */


class Solution {
    
    
    public int[][] updateMatrix(int[][] mat) {
        int R=mat.length;
        int C=mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
            {
                if(mat[i][j]==0). //enqueue 0 , try to find the level of 1's
                    queue.offer(new int[]{i,j});
                else
                    mat[i][j]=-1;  //instead of new visited arrya re-use 
            }
        int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
        int level=1;
         while(!queue.isEmpty())
        {
             int size = queue.size();
            while(size >0){
                size--;
             int[] p = queue.poll();
            
            for(int i=0;i<4;i++)
            {
                int x=p[0]+dir[i][0];
                int y=p[1]+dir[i][1];
                
                if(x>=0 && y>=0 && x<R && y<C && mat[x][y]==-1)
                {
                    mat[x][y]=level;
                    queue.offer(new int[]{x,y});
                }
            }
            }
             
             level++;
         }
        
        
        return mat;
    }
    
}
