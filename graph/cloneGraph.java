package cp.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class cloneGraph {
    Map<Node,Node> hm = new HashMap<>();
    public Node cloneGraph(Node node) {
        
        if(node == null)
            return node;
        
        if(hm.containsKey(node))
        return hm.get(node);
        
        
        Node cloneNode = new Node(node.val,new ArrayList<Node>());
        hm.put(node,cloneNode);
        
        for(Node n:node.neighbors)
            cloneNode.neighbors.add(cloneGraph(n));
        
        return cloneNode;
        
    }
}
