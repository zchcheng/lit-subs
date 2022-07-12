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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        if (fast != null) cur = cur.next;
        
        ListNode p1 = prev;
        ListNode p2 = cur;
        
        while(p1 != null || p2 != null) {
            if (p1 == null && p2 != null) break;
            if (p1 != null && p2 == null) break;
            if (p1.val != p2.val) break;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1 == null && p2 == null;
    }
}