/*

https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
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
              // After reversing is done, beforeStart's next should now point to End pointer
                beforeStart.next=end;
               // Start's next should point to temp(intial End's Next)
                start.next=temp;
                // After that, beforeStart should be moved to the place of Start Pointer
                beforeStart=start;
              
              // End should start from temp
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
        // We will stop when our Previous(p) pointer becomes equal to our End Pointer
        while(prev!=end)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

            
        }
    }
}
