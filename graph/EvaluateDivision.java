
/*


399. Evaluate Division

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.

*/

class Solution {
    class Node {
		String key;
		double val;

		public Node(String k, double v) {
			key = k;
			val = v;
		}
	}
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       Map<String, List<Node>> g = buildGraph(equations, values);
		double[] result = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++)
			result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), g);

		return result; 
      
    }
    
    private double dfs(String src, String dest, Set<String> visited, Map<String, List<Node>> g) {
		if (!(g.containsKey(src) && g.containsKey(dest)))
			return -1.0;

		if (src.equals(dest))
			return 1.0;

		visited.add(src);

		for (Node node : g.get(src)) {
			if (!visited.contains(node.key)) {
				double ans = dfs(node.key, dest, visited, g);
				if (ans != -1.0)
					return ans * node.val;
			}
		}
		return -1.0;
	}

	private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {
		Map<String, List<Node>> g = new HashMap<>();

		for (int i = 0; i < values.length; i++) {
			String src = eq.get(i).get(0);
			String dest = eq.get(i).get(1);

			g.putIfAbsent(src, new ArrayList<>());
			g.putIfAbsent(dest, new ArrayList<>());

			g.get(src).add(new Node(dest, values[i]));
			g.get(dest).add(new Node(src, 1 / values[i]));
		}
		return g;

	}

}
