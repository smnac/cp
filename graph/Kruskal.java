/*
1584. Min Cost to Connect All Points
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

*/



class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int vertex = points.length;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        boolean[] mstMap = new boolean[vertex];
        pq.add(new int[]{0,0});
        int cost=0;
        int edgeCount=0;
        
        while(edgeCount<vertex)
        {
            int[] element=pq.poll();
            int wt=element[0];
            int node=element[1];
            
            if(mstMap[node])
                continue;
            
            mstMap[node]=true;
            cost+=wt;
            edgeCount++;
            
            for (int nextNode = 0; nextNode < vertex; ++nextNode) {
                
                if (!mstMap[nextNode]) {
                    int nextWeight = Math.abs(points[node][0] - points[nextNode][0]) + 
                                     Math.abs(points[node][1] - points[nextNode][1]);
        
                    pq.add(new int[]{nextWeight, nextNode});
                }
            }
            
            
        }
        
        return cost;
    }
}
