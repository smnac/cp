/*

Tree Traversals
https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

*/

/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
	static class Pair
	{
		BinaryTreeNode<Integer> node;
		int order;
		Pair(BinaryTreeNode<Integer> n,int o)
		{
			node=n;
			order=o;

		}
	}
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
		Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,0));
        for(int i=0;i<3;i++)
		res.add(new ArrayList<>());
		if(root==null)
		return res;
		while(!stack.isEmpty())
		{
			Pair p = stack.pop();
			BinaryTreeNode<Integer> cur= p.node;
			int order = p.order;

			if(order==0)
			{
			  res.get(1).add(cur.data);
			  stack.push(new Pair(cur,order+1));
			  if(cur.left!=null)
			  stack.push(new Pair(cur.left,0));

			}
			else if(order==1)
		    {
               res.get(0).add(cur.data);
			   stack.push(new Pair(cur,order+1));
			    if(cur.right!=null)
			  stack.push(new Pair(cur.right,0));

			}
			else
			{
              res.get(2).add(cur.data);
			}
		}

		return res;

    }
}
