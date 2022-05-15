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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        if (head.next.next == null) return head.val + head.next.val;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        ListNode back = prev;
        int res = Integer.MIN_VALUE;
        
        while(prev != null && slow != null) {
            res = Math.max(res, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }
        
        return res;
    }
}