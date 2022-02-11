package cp.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new LinkedList<>();
        helper(root,res,0);
        return res;
        
    }
    
    void helper(TreeNode root, List<Integer> res,int level)
    {
        if(root==null)
            return;
        if(level==res.size())
            res.add(root.val);
        helper(root.right,res,level+1);
        helper(root.left,res,level+1);
    }
}
