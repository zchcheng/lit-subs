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
        return bottomUpMergeSort(head);
    }
    
    ListNode bottomUpMergeSort(ListNode head) {
        ListNode next = null;
        ListNode res = new ListNode();
        res.next = head;
        
        for(int sz = 1; ; sz *= 2) {
            ListNode list1 = res.next;
            ListNode list2 = getNext(list1, sz);
            ListNode current = res;
            
            if (list2 == null) break;
            
            while(list1 != null || list2 != null) {
                next = getNext(list2, sz);
                
                ListNode[] merged = mergeTwoList(list1, list2);
                
                current.next = merged[0];
                current = merged[1];
                
                list1 = next;
                list2 = getNext(list1, sz);
            }
        }
        
        return res.next;
    }
    
    ListNode getNext(ListNode node, int n) {
        for(int i = 0; i < n - 1 && node != null; i++) {
            node = node.next;
        }
        
        if (node == null) return null;
        
        ListNode res = node.next;
        node.next = null;
        
        return res;
    }
    
    ListNode[] mergeTwoList(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        
        while(list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val < list2.val)) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        current.next = null;
        
        return new ListNode[] { result.next, current };
    }
    
    ListNode topDownMergeSort(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode[] heads = partition(head);
        
        ListNode head1 = topDownMergeSort(heads[0]);
        ListNode head2 = topDownMergeSort(heads[1]);
        
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