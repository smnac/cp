/*
https://leetcode.com/problems/reverse-nodes-in-k-group/

*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || head.next==null || k==1)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode beforeStart=dummy, end=head;
        int i=0;
        while(end!=null)
        {
            i++;
            if(i%k==0)
            {
                ListNode start=beforeStart.next,temp=end.next;
                reverse(start,end);
                beforeStart.next=end;
                start.next=temp;
                beforeStart=start;
                end=temp;
            }
            else
            {
                end=end.next;
            }
        }
        
        return dummy.next;
    }
        
    
    
    void reverse(ListNode start,ListNode end)
    {
        ListNode cur=start, next=null,prev=null;
        
        while(prev!=end)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

            
        }
    }
}
