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
        ListNode oh = odd;
        ListNode eh = even;
        
        boolean isOdd = true;
        
        while(head != null) {
            ListNode next = head.next;
            
            if (!isOdd) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            
            head = head.next;
            isOdd = !isOdd;
        }
        
        odd.next = eh.next;
        even.next = null;
        
        return oh.next;
    }
}