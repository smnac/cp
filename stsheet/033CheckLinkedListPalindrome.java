/*

https://leetcode.com/problems/palindrome-linked-list/
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode fp = head;
        ListNode sp = head;
        
        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
        }
        if(fp!=null){ // this is to verify the list is odd length, fp.next == null means it is even length
            sp = sp.next; // advance slow pointer, because of odd case ignore the middle element in the original list for palindrom check.
        }
        
        ListNode revHead = reverseList(sp);
        while(revHead!=null){
            //System.out.println(revHead.val +":" + head.val);
            if(revHead.val != head.val){
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return true;
        
    }
    
    private ListNode reverseList(ListNode curHead){
        if(curHead==null || curHead.next==null){
            return curHead;
        }
        ListNode prev = null;
        ListNode cur = curHead;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
