/*
https://leetcode.com/problems/rotate-list/

*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null ) { 
        return head;
    }
    int l = 0;
    ListNode p = head;
    while (p != null) {
        l++;
        p = p.next;
    }
    k %= l;
    if (k == 0) { // return original list
        return head;
    }
    ListNode fast = head, slow = head;
    for (int i = 0; i < k; i++) {
        fast = fast.next;
    }
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    fast.next = head;
    ListNode ret = slow.next;
    slow.next = null;
    return ret;
        
        
        
    }
}
