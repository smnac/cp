/*
https://leetcode.com/problems/add-two-numbers/

*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur=head;
        
         if(l1==null)
             return l2;
        if(l2==null)
            return l1;
        int carry=0;
        
        while(l1!=null && l2!=null)
        {
            l1.val+=l2.val+carry;
            carry=0;
            if(l1.val>9)
            {
                l1.val%=10;
                carry=1;
            }
            cur.next=l1;
            l1=l1.next;
            l2=l2.next;
            cur=cur.next;
           
        }
        
        while(l1!=null)
        {
           l1.val+=carry;
            carry=0;
              if(l1.val>9)
            {
                l1.val=0;
                carry=1;
            }
            cur.next=l1;
            l1=l1.next;
            cur=cur.next;
            
        }
        
         while(l2!=null)
        {
           l2.val+=carry;
            carry=0;
              if(l2.val>9)
            {
                l2.val=0;
                carry=1;
            }
            cur.next=l2;
            l2=l2.next;
            cur=cur.next;
            
        }
        if(carry==1)
            cur.next=new ListNode(1);
        
        return head.next;
        
    }
}
