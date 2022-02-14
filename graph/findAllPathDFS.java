package cp.graph;

/*

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
*/

import java.util.ArrayList;
import java.util.List;

public class findAllPathDFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        if(graph==null || graph.length==0 )
            return ans;
        
        DFS(graph,0,new ArrayList<>(),ans);
        
        return ans;
    }
    
    void DFS(int[][] graph, int node,List<Integer> cur,List<List<Integer>> ans)
    {
        cur.add(node);
        if(node==graph.length-1)
        {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for(int vertex:graph[node])
        {
            DFS(graph,vertex,cur,ans);
            cur.remove(cur.size()-1);
        }
        
    }
}
