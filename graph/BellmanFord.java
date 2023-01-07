/*

Distance from the Source (Bellman-Ford Algorithm)

https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm

//imp

1. Dijkstra doesn't work for negative weight and graph with negative cycle it give TLE
2. For negative weight graphs use Bellman Ford
3. Apply edge relaxation for V-1 time and Vth time it should not update the value.. and it is intuition for n-1 times relaxation

*/


class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        
        dist[S]=0;
        for(int i=0;i<V-1;i++)
        for(ArrayList<Integer> edge : edges)
        {
            int u = edge.get(0);
            int v=edge.get(1);
            int wt=edge.get(2);
            if(dist[u]!=(int)1e8 && wt + dist[u] < dist[v])
                dist[v]= wt+dist[u];
        }
        
        for(ArrayList<Integer> edge : edges)
        {
            int u = edge.get(0);
            int v=edge.get(1);
            int wt=edge.get(2);
            if(dist[u]!=(int)1e8 && wt + dist[u] < dist[v])
                return new int[]{-1};
        }
        
        return dist;
        
    }
}
