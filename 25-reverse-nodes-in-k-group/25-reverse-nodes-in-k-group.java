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
        ListNode res = new ListNode();
        
        res.next = head;
        
        ListNode current = head;
        ListNode prev = res;
        
        while(current != null) {
            ListNode[] p = reverse(current, k);
            prev.next = p[0];
            
            if (p[1] != null) {
                prev = p[1];
                current = p[1].next;
            } else break;
        }
        
        return res.next;
    }
    
    ListNode[] reverse(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode current = head;
        
        for(int i = 0; i < k; i++) {
            if (current == null) {
                ListNode[] r = reverse(res.next, i);
                return new ListNode[] {
                    r[0],
                    null
                };
            }
            
            ListNode next = current.next;
            current.next = res.next;
            res.next = current;
            current = next;
        }
        
        head.next = current;
        
        return new ListNode[] { res.next, head };
    }
    
    void print(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
}