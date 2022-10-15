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
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        
        while(head != null) {
            ListNode next = head.next;
            
            head.next = result.next;
            result.next = head;
            
            head = next;
        }
        
        return result.next;
    }
}