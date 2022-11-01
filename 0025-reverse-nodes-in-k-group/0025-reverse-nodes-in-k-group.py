# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        result = ListNode(-1, head)
        prev = result
        
        nxt = self.getK(prev, k)
        
        while nxt:
            tmp_next = nxt.next
            nxt.next = None
            tail = prev.next
            prev.next = self.reverse(prev.next)
            prev = tail
            prev.next = tmp_next
            nxt = self.getK(prev, k)
        
        return result.next
        

    def reverse(self, head):
        result = ListNode()
        
        while head:
            nxt = head.next
            head.next = result.next
            result.next = head
            head = nxt
            
        return result.next
            
        
    def getK(self, head, k):
        for i in range(k):
            if not head:
                return None
            head = head.next
            
        return head
        
