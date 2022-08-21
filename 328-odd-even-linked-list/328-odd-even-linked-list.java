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
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode e = even;
        ListNode o = odd;
        
        for(int i = 0; head != null; head = head.next, i++) {
            if (i % 2 == 0) {
                e.next = head;
                e = e.next;
            } else {
                o.next = head;
                o = o.next;
            }
        }
        
        e.next = odd.next;
        o.next = null;
        
        return even.next;
    }
}