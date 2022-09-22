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
        result.next = head;
        
        ListNode prev = result;
        
        while(prev != null) {
            ListNode next = prev;
            int numOfNode = 0;
            
            for(; numOfNode < k && next != null; numOfNode++, next = next.next);
            
            if (numOfNode < k || next == null) break;
            
            ListNode tail = next.next;
            next.next = null;
            
            ListNode[] reversedList = reverseList(prev.next);
            
            prev.next = reversedList[0];
            prev = reversedList[1];
            prev.next = tail;
        }
        
        return result.next;
    }
    
    // return reversed head & tail 
    ListNode[] reverseList(ListNode head) {
        ListNode result = new ListNode();
        ListNode current = head;
        
        while(current != null) {
            ListNode next = current.next;
            
            current.next = result.next;
            result.next = current;
            
            current = next;
        }
        
        return new ListNode[] { result.next, head };
    }
}