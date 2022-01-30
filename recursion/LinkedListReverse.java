package cp.recursion;

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedListReverse {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        return head;
        
        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
         
     }
    
}
