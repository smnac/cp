/*
https://leetcode.com/problems/linked-list-cycle-ii/

*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next==null)
            return null;
        
        ListNode fp = head;
        ListNode sp = head;
        
        while(fp!=null && fp.next!=null)
        {
            fp=fp.next.next;
            sp=sp.next;
            
            if(fp==sp)
            {
                ListNode cur =head;
                while(cur!=sp)
                {
                    cur=cur.next;
                    sp=sp.next;
                }
                return cur;
            }
        }
        
        return null;
        
    }
}
