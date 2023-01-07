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
