/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        if(sizeA>sizeB)
            headA=getNewHead(headA,sizeA-sizeB);
        else if(sizeB>sizeA)
            headB=getNewHead(headB,sizeB-sizeA);
        
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
        
    }
    
    private int getSize(ListNode head)
    {
        int count=0;
        while(head!=null)
        {
            count++;
            head=head.next;
            
        }
        return count;
    }
    
    private ListNode getNewHead(ListNode head,int count)
    {
        while(count>0)
        {
            head=head.next;
            count--;
        }
        return head;
    }
}
