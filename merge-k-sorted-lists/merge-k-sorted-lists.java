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
        ListNode result = new ListNode();
        ListNode current = result;
        
        PriorityQueue<Pair<ListNode, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey().val - b.getKey().val);
        
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            pq.offer(new Pair<>(lists[i], i));
            lists[i] = lists[i].next;
        }
        
        while(!pq.isEmpty()) {
            Pair<ListNode, Integer> p = pq.poll();
            current.next = p.getKey();
            current = current.next;
            
            if (lists[p.getValue()] != null) {
                pq.offer(new Pair<>(lists[p.getValue()], p.getValue()));
                lists[p.getValue()] = lists[p.getValue()].next;
            }
        }
        
        return result.next;
    }
}