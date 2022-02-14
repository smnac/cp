package cp.graph;

/*
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 104]

*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/*
// Definition for a Node.
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
*/

class NArrayLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(true)
        {
            int nodeCount=0;
            nodeCount=queue.size();
            List<Integer> ans = new ArrayList<>();
            if(nodeCount==0)
                break;
            while(nodeCount>0){
            Node cur=queue.poll();
           // System.out.print(cur.val);
                ans.add(cur.val);
            nodeCount--;
            for(Node temp:cur.children)
                queue.add(temp);
            }
            
           // System.out.println();
            res.add(ans);
        }
        
        return res;
        
        
    }
}
