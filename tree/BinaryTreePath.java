import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, return all root-to-leaf paths in any order. 
 * Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
 * */


public class BinaryTreePath {
	 public List<String> binaryTreePaths(TreeNode root) {
	        
	        List<String> res = new ArrayList<>();
	        helper(root,"",res);
	        return res;
	        
	    }
	    
	    void helper(TreeNode root,String path,List<String> res)
	    {
	        if(root==null)
	            return;
	        
	        if(root.left==null && root.right==null)
	            res.add(path+root.val);
	        else
	            path=path+root.val+"->";
	        
	        helper(root.left,path,res);
	        helper(root.right,path,res);
	    }

}
