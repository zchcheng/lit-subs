# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        r = ListNode()
        
        while head:
            next_node = head.next
            head.next = r.next
            r.next = head
            head = next_node
            
        return r.next