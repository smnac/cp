/*
https://www.interviewbit.com/problems/path-to-given-node/
Problem Description

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.

*/

public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(A==null)
        return res;
        helper(A,B,res);
        return res;
    }
    boolean helper(TreeNode A,int B,ArrayList<Integer> res)
    {
        if(A==null)
        return false;
        res.add(A.val);
        if(A.val==B)
        return true;
        
        if(helper(A.left,B,res) || helper(A.right,B,res))
            return true;
        
        res.remove(res.size()-1);
        return false;
    }
}
