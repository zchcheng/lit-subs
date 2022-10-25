# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        d = ListNode(-1, head)
        
        fast = d
        for i in range(n):
            fast = fast.next
                
        slow = d
        while fast and fast.next:
            slow = slow.next
            fast = fast.next
            
        next_node = slow.next
        if next_node: slow.next = slow.next.next
        del(next_node)
        
        return d.next