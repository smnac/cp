/*
https://leetcode.com/problems/delete-node-in-a-linked-list/
*/
class Solution {
    public void deleteNode(ListNode node) {
        if(node.next==null)
        {
            node=null;
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;
        
    }
}
