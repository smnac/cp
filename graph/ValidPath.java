import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	
	
	public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> adjList=new HashMap<>();
		//List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n;i++)
			adjList.put(i, new LinkedList<>());
		
		for(int[]e:edges)
		{
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
			
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited=new boolean[n];
		queue.add(source);
		int node=0;
		while(!queue.isEmpty())
		{
			node=queue.poll();
			
			if(node==destination)
				return true;
			
			if(visited[node])
				continue;
			visited[node]=true;
			
			for(int vertex:adjList.get(node))
				queue.offer(vertex);
		}
		
		return false;
		
		
	}
	
	public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> adjList=new HashMap<>();
		for(int i=0;i<n;i++)
			adjList.put(i, new LinkedList<>());
		
		for(int[]e:edges)
		{
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
			
		}
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited=new boolean[n];
		stack.push(source);
		int node=0;
		while(!stack.isEmpty())
		{
			node=stack.pop();
			
			if(node==destination)
				return true;
			
			if(visited[node])
				continue;
			visited[node]=true;
			
			for(int vertex:adjList.get(node))
				stack.push(vertex);
		}
		
		return false;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
