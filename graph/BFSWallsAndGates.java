
/*

286. Walls and Gates
You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.


*/


class BFSWallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        
        List<int[]> list = new ArrayList<>();
        int m=rooms.length;
        int n=rooms[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(rooms[i][j]==0)
                {
                    list.add(new int[]{i,j});
                    
                }
            }
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir={{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] item : list)
            queue.offer(item);
        int step=1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int j=0;j<size;j++)
            {
                int[] p = queue.poll();
            for(int i=0;i<4;i++)
            {
                int r=p[0]+dir[i][0];
                int c=p[1]+dir[i][1];
                
                if(r>=0 && r<m && c>=0 && c<n && rooms[r][c]==Integer.MAX_VALUE && !visited[r][c])
                {
                    visited[r][c]=true;
                    rooms[r][c]=step;
                    queue.add(new int[]{r,c});
                }
                
            }
                
                
        }
            step++;
        
    }
    }
}
