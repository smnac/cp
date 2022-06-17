/*

968. Binary Tree Cameras
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:


Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cameraCount=0;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        
        if(root==null)
            return 0;
        
        covered = new HashSet<>();
        covered.add(null); //for excluding leaves
        helper(root,null);
        return cameraCount;
          
    }
    
    public void helper(TreeNode cur, TreeNode parent)
    {
        if(cur==null)
            return;
        
        helper(cur.left,cur);
        helper(cur.right,cur);
        
        /*
           From bottom excluding leaf node check do we need to add camera.
           -> If parent is null and node is uncovered
           -> OR any of left/right child is uncovered
        
        */
        if(parent==null && !covered.contains(cur) || !covered.contains(cur.left) || !covered.contains(cur.right))
           {
               covered.add(cur);
               covered.add(parent);
               covered.add(cur.left);
               covered.add(cur.right);
               cameraCount++;
               
           }
    }
}
