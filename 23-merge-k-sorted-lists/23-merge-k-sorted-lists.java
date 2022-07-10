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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode current = head;
        
        PriorityQueue<Pair<ListNode, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey().val - b.getKey().val);
        
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            pq.offer(new Pair(lists[i], i));
            lists[i] = lists[i].next;
        }
        
        while(!pq.isEmpty()) {
            Pair<ListNode, Integer> p = pq.poll();
            
            current.next = p.getKey();
            current = current.next;
            current.next = null;
            
            int idx = p.getValue();
            
            if (lists[idx] != null) {
                pq.offer(new Pair<>(lists[idx], idx));
                lists[idx] = lists[idx].next;
            }
        }
        
        return head.next;
    }
}