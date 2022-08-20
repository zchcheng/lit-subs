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
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0, head);
        
        ListNode pre = root;
        ListNode cur = head;
        
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        
        return root.next;
    }
}