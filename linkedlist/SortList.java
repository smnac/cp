package cp.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

class SortList {
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev_mid=head;
        
        while(fast!=null && fast.next!=null)
        {
            prev_mid=slow;
            slow=slow.next;
            fast=fast.next.next;
                
        }
        prev_mid.next=null; //mark end of left list
        ListNode leftList=sortList(head); //left list head->mid-1
        ListNode rightList=sortList(slow); //right list mid-> end 
        return mergeList(leftList,rightList);
       
    }
    
    private ListNode mergeList(ListNode head1,ListNode head2)
    {   ListNode head=new ListNode();
        ListNode cur=head;
        while(head1!=null & head2!=null)
        {
            if(head1.val<head2.val)
            {
                cur.next=head1;
                head1=head1.next;
            }
            else
            {
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
            
        }
     
        while(head1!=null)
        {
            cur.next=head1;
            head1=head1.next;
            cur=cur.next;
        }
     
      while(head2!=null)
      {
          cur.next=head2;
          head2=head2.next;
          cur=cur.next;
      }
     cur.next=null;
     return head.next;
     
    }
}