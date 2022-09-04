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
    public void reorderList(ListNode head) {
        ListNode second = splitHalf(head);
        ListNode reversed = reverse(second);
        
        ListNode first = head.next;
        ListNode cur = head;
        
        while(first != null || reversed != null) {
            if (reversed != null) {
                cur.next = reversed;
                reversed = reversed.next;
                cur = cur.next;
            }
            
            if (first != null) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }
        }
    }
    
    ListNode splitHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode res = slow.next;
        slow.next = null;
        
        return res;
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}