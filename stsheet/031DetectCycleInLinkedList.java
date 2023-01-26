/*
 https://leetcode.com/problems/linked-list-cycle/
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        
        ListNode fp = head;
        ListNode sp = head;
        
        while(fp!=null && fp.next!=null)
        {
            fp=fp.next.next;
            sp=sp.next;
            if(fp==sp)
                return true;
        }
        
        return false;
        
    }
}
