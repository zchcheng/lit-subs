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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode prevLast = result;
        
        while(head != null) {
            ListNode last = getK(head, k);
            
            if (last == null) {
                prevLast.next = head;
                head = null;
            } else {
                ListNode next = last.next;
                
                reverse(head, last);
                
                prevLast.next = last;
                prevLast = head;
                head = next;
            }
        }
        
        return result.next;
    }
    
    ListNode getK(ListNode head, int k) {
        ListNode current = head;
        
        for(int i = 1; i < k && current != null; i++, current = current.next) {
            if (current == null) return null;
        }
        
        return current;
    }
    
    void reverse(ListNode start, ListNode end) {
        ListNode head = new ListNode();
        
        while(start != null) {
            ListNode next = start.next;
            start.next = head.next;
            head.next = start;
            start = next;
            
            if (head.next == end) return;
        }
    }
}