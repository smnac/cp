/*
https://leetcode.com/problems/copy-list-with-random-pointer/

*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return head;
        
        Node newhead = new Node(0);
        Node head_curr = head;
        Node new_curr = newhead;
        
        Map<Node,Node> map = new HashMap();
        
        while(head_curr != null){
            new_curr.next = new Node(head_curr.val);
            new_curr = new_curr.next;
            map.put(head_curr,new_curr);
            head_curr = head_curr.next;
        }
        
        head_curr = head;
        new_curr = newhead.next;
        
        while(head_curr != null){
            new_curr.random = map.get(head_curr.random);
            new_curr = new_curr.next;
            head_curr = head_curr.next;
        }
        
        return newhead.next;
    
        
    }
}
