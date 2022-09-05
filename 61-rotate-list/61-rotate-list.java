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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        ListNode cur = head;
        
        int size = 1;
        while(cur.next != null) { 
            cur = cur.next;
            size++;
        }
        
        cur.next = head;
        ListNode prev = null;
        
        cur = head;
        for(int i = 0; i < size - (k % size); i++) {
            prev = cur;
            cur = cur.next;
        }
        
        prev.next = null;
        
        return cur;
    }
}