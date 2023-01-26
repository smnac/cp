/*
https://leetcode.com/problems/reverse-linked-list/
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head,prev=null,next=null;
        
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
        
    }
}
