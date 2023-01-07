/*

https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree

Minimum Spanning Tree
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 
*/

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	  PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
	  ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	  
	   for(int i=0;i<V;i++)
	    adj.add(new ArrayList<>());
	    
	    for(int i=0;i<E;i++){
	    adj.get(edges[i][0]).add(new int[] {edges[i][1],edges[i][2]});
	    adj.get(edges[i][1]).add(new int[] {edges[i][0],edges[i][2]});
	    }
	    
	    boolean[] visited = new boolean[V];
	    int sum=0;
	    pq.offer(new int[]{0,0});
	    
	    while(!pq.isEmpty())
	    {
	        int node = pq.peek()[1];
	        int dist = pq.peek()[0];
	          pq.poll();
	        if(visited[node])
	          continue;
	        visited[node]=true;
	        sum=sum+dist;
	      
	        for(int[] cur:adj.get(node))
	        {
	            int nn=cur[0];
	            int nd=cur[1];
	            
	            if(!visited[nn])
	            {
	               pq.offer(new int[]{nd,nn}); 
	            }
	            
	            
	        }
	    }
	    
	    return sum;
	  
	}
}
