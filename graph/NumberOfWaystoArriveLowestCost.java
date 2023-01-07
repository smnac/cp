/*
1976. Number of Ways to Arrive at Destination

https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/


*/

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        int m = roads.length;
        
        for(int i=0;i<m;i++)
        {
            adj.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            adj.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }
        
        int[] dist = new int[n];
        long[] ways = new long[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.offer(new int[]{0,0});
        
        while(!queue.isEmpty())
        {
            int distance = queue.peek()[0];
            int node = queue.peek()[1];
            queue.poll();
           
            for(int[] an:adj.get(node))
            {
                int nn = an[0];
                int nd=an[1];
                
                if(distance+nd<dist[nn])
                {
                    dist[nn]=distance+nd;
                    ways[nn]=ways[node];
                    queue.offer(new int[]{dist[nn],nn});
                }
                else if(distance+nd==dist[nn])
                {
                    ways[nn]=(ways[node]+ways[nn])%((int)1e9+7);
                }
            }
        }
         return (int)ways[n-1];    
        
    }
}
