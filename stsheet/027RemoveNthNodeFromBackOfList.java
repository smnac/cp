/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast=head;
        while(fast!=null && n>0)
        {
            fast=fast.next;
            n--;
            
        }
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null)
        {
            fast=fast.next;
            prev=slow;
            slow=slow.next;
        }
        if(prev==null && head!=null)
            return head.next;
        
        prev.next=slow.next;
        return head;
        
        
    }
}
