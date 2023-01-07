
/*
https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix
Implementing Dijkstra Algorithm
*/
//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance-b.distance);
       
       int[] dist = new int[V];
       Arrays.fill(dist,(int)1e9);
       
       dist[S]=0;
       
       pq.offer(new Pair(0,S));
       
       while(!pq.isEmpty())
       {
           int distance = pq.peek().distance;
           int node = pq.peek().node;
           pq.poll();
           for(ArrayList<Integer> n:adj.get(node))
           {
               int adjNode = n.get(0);
               int weight = n.get(1);
               if(weight+distance<dist[adjNode])
               {
                   dist[adjNode]=weight+distance;
                   pq.offer(new Pair(dist[adjNode],adjNode));
               }
           }
       }
       
       return dist;
       
       
    }

/*
https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph

*/
 public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++) // <= bcoz one based index
        adj.add(new ArrayList<>());
        
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        
        for(int i=1;i<=n;i++)
        {
            dist[i]=(int)1e9;
            parent[i]=i;
        }
        
        dist[1]=0;
        pq.offer(new Pair(0,1));
        
        while(!pq.isEmpty())
        {
            int distance = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            
            for(Pair p : adj.get(node))
            {
                if(p.first + distance < dist[p.second])
                {
                    dist[p.second]=p.first + distance;
                    parent[p.second]=node;
                    pq.offer(new Pair(dist[p.second],p.second));
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dist[n]==(int)1e9){
         path.add(-1);
         return path;
        }
  
        int node =n;
        while(parent[node]!=node)
        {
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
        
        
        
    }



/*
https://leetcode.com/problems/path-with-minimum-effort/
ou are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

*/


class Solution {
    class Tuple
    {
        int distance;
        int row;
        int col;
        
        public Tuple(int d,int r,int c)
        {
            distance=d;
            row=r;
            col=c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.distance-b.distance);
        
        int n = heights.length;
        int m=heights[0].length;
        
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],(int)1e9);
        
        queue.offer(new Tuple(0,0,0));
        
        int[] dix = {1,-1,0,0};
        int[] diy = {0,0,1,-1};
        while(!queue.isEmpty())
        {
            int diff = queue.peek().distance;
            int r = queue.peek().row;
            int c = queue.peek().col;
            queue.poll();
            if(r==n-1 && c==m-1)
                return diff;
            
            for(int i =0;i<4;i++)
            {
                int nr=r+dix[i];
                int nc=c+diy[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m)
                {
                    int neweffort = Math.max(Math.abs(heights[r][c]-heights[nr][nc]),diff);
                    if(neweffort<dist[nr][nc])
                    {
                        dist[nr][nc]=neweffort;
                        queue.offer(new Tuple(neweffort,nr,nc));
                    }
                }
            }
            
            
        }
        
        return 0;
        
        
        
    }
}
