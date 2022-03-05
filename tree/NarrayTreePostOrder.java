import java.util.ArrayList;
import java.util.List;

/*Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)*/

public class NarrayTreePostOrder {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	 public List<Integer> postorder(Node root) {
	        
	        List<Integer> res = new ArrayList<>();
	        
	        helper(root,res);
	        return res;
	        
	    }
	    
	    void helper(Node root, List<Integer> res)
	    {
	        if(root==null)
	            return;
	            
	         for(Node node:root.children)
	             helper(node,res);
	        res.add(root.val);
	    }

}
