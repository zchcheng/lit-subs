# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(pq, (lists[i].val, i))
            
        res = ListNode()
        cur = res
        while pq:
            val, idx = heapq.heappop(pq)
            cur.next = lists[idx]
            cur = cur.next
            lists[idx] = lists[idx].next
            if lists[idx]:
                heapq.heappush(pq, (lists[idx].val, idx))
                
        return res.next
            
            
