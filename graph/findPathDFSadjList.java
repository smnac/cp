package cp.graph;

/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class findPathDFSadjList {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stk=new Stack<>();
        stk.add(source);
        boolean[] visited=new boolean[n];
        int node=0;
        while(!stk.isEmpty())
        {
            node=stk.pop();
            if(node==destination)
                return true;
            if(visited[node])
                continue;
            visited[node]=true;
            for(int vertex:adjList.get(node))
            {
                stk.push(vertex);
            }
            
        }
        
        return false;
        
        
        
    }
}
