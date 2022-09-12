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
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode[] heads = partition(head);
        
        ListNode head1 = mergeSort(heads[0]);
        ListNode head2 = mergeSort(heads[1]);
        
        ListNode res = new ListNode();
        ListNode current = res;
        
        while(head1 != null || head2 != null) {
            if (head1 != null && (head2 == null || head1.val <= head2.val)) {
                ListNode next = head1.next;
                current.next = head1;
                head1 = next;
            } else {
                ListNode next = head2.next;
                current.next = head2;
                head2 = next;
            }
            current = current.next;
        }
        
        current.next = null;
        
        return res.next;
    }
    
    ListNode[] partition(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode[] res = new ListNode[] { head, slow.next };
        slow.next = null;
        
        return res;
    }
}