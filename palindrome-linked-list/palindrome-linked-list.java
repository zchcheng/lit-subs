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
        // a -> b -> b -> a
        //           ^
        //      ^
        
        // a -> b -> a
        //           ^
        //      ^
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        ListNode reversed = reverse(slow.next);
        
        while(reversed != null && head != null) {
            if (reversed.val != head.val) return false;
            reversed = reversed.next;
            head = head.next;
        }
        
        return true;
    }
    
    ListNode reverse(ListNode head) {
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