package cp.tree;


/*
Design an algorithm to serialize and deserialize 
a binary tree. There is no restriction on how your 
serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized 
to a string and this string can be deserialized to the 
original tree structure.

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
*/
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root==null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node==null)
            {
                res.append("null,");
                continue;
            }
            res.append(node.val+",");
            q.add(node.left);
            q.add(node.right);
        }
        res.setLength(res.length() - 1);
        return res.toString();
        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data=="")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode cur=q.poll();
            if(!values[i].equals("null"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                cur.left=left; 
                q.add(left);
            }
            if(!values[++i].equals("null"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                cur.right=right;
                q.add(right);
                
            }
            
        }
        return root;
        
    }
}
