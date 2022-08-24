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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        
        mid.next = null;
        
        ListNode sorted1 = sortList(head);
        ListNode sorted2 = sortList(second);
        
        ListNode res = new ListNode();
        ListNode cur = res;
        
        while(sorted1 != null || sorted2 != null) {
            int v1 = (sorted1 == null)? Integer.MAX_VALUE : sorted1.val;
            int v2 = (sorted2 == null)? Integer.MAX_VALUE : sorted2.val;
            
            if (v1 <= v2) {
                cur.next = sorted1;
                cur = cur.next;
                sorted1 = sorted1.next;
                cur.next = null;
            } else {
                cur.next = sorted2;
                cur = cur.next;
                sorted2 = sorted2.next;
                cur.next = null;
            }
        }
        
        return res.next;
    }
    
    ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        for(; fast != null && fast.next != null && fast.next.next != null; fast = fast.next.next, slow = slow.next);
        return slow;
    }
}