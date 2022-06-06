/*


160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.

*/


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int sizeA=listSize(headA);
        int sizeB=listSize(headB);
        ListNode curA=headA;
        ListNode curB=headB;
        
        if(sizeA>sizeB)
        {
            for(int i=0;i<(sizeA-sizeB);i++)
                curA=curA.next;
        }
        
         if(sizeB>sizeA)
        {
            for(int i=0;i<(sizeB-sizeA);i++)
                curB=curB.next;
        }
        
        while(curA!=null && curB!=null)
        {
            if(curA==curB)
                return curA;
            curA=curA.next;
            curB=curB.next;
        }
        return null;
        
    }
    
    public int listSize(ListNode head)
    {
        int count=0;
        ListNode cur=head;
        while(cur!=null)
        {
            cur=cur.next;
            count++;
        }
        return count;
    }
}
