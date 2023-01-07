/*

787. Cheapest Flights Within K Stops
https://leetcode.com/problems/cheapest-flights-within-k-stops/
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        int m = flights.length;
        
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,src,0});
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        
        while(!queue.isEmpty())
        {
            int stops = queue.peek()[0];
            int node = queue.peek()[1];
            int cost = queue.peek()[2];
            queue.poll();
            if(stops>k)
                continue;
            
            for(int[] an:adj.get(node))
            {
                int adjNode = an[0];
                int weight = an[1];
                
                if(cost+weight<dist[adjNode] && stops<=k)
                {
                    dist[adjNode]=cost+weight;
                    queue.offer(new int[]{stops+1,adjNode,dist[adjNode]});
                }
            }
            
            
        }
        
        if(dist[dst]==(int)1e9)
            return -1;
        return dist[dst];
        
    }
}
