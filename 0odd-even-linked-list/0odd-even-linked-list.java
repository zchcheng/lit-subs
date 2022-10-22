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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oh = new ListNode();
        ListNode eh = new ListNode();
        ListNode co = oh;
        ListNode ce = eh;
        
        int cnt = 0;
        while(head != null) {
            ListNode cur = (cnt % 2 == 0)? ce : co;
            
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = null;
            
            if (cnt % 2 == 0) ce = cur;
            else co = cur;
            
            cnt++;
        }
        
        ce.next = oh.next;
        
        return eh.next;
    }
}