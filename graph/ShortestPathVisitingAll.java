package cp.graph;

import java.util.ArrayList;

class ShortestPathVisitingAll {
    public int shortestPathLength(int[][] graph) {
        int N=graph.length;
        if(N==1)
            return 0;
        
        int destination = (1<<N)-1; // don't forget precedence
        
        boolean[][] visited = new boolean[N][destination+1];
        ArrayList<int[]> queue= new ArrayList<>();
        
        for(int i=0;i<N;i++)
        {
            queue.add(new int[] {i,1<<i});
            visited[i][1<<i]=true;
        }
        
        int edges=0;
        
        while(!queue.isEmpty())
        {
            ArrayList<int[]> nextQueue= new ArrayList<>();
            for(int i=0;i<queue.size();i++)
            {
                int[] nodeMask=queue.get(i);
                for(int node:graph[nodeMask[0]]){
                    int nextMask= nodeMask[1] | (1<<node);
                        if(nextMask==destination)
                            return edges+1;
                    
                    if(!visited[node][nextMask])
                    {
                        visited[node][nextMask]=true;
                        nextQueue.add(new int[]{node,nextMask});
                    }
                }
            }
            edges++;
            queue=nextQueue;
            
            
        }
        return -1;
        
    }
}