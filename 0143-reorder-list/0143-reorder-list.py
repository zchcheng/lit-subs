# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        mid = self.findMid(head)
        hh = self.reverse(mid.next)
        mid.next = None
        
        ptr = head
        
        while ptr and hh:
            next = ptr.next
            hnext = hh.next
            
            ptr.next = hh
            hh.next = next
            hh = hnext
            ptr = next
        
        
    def reverse(self, head):
        res = ListNode()
        
        while head:
            next = head.next
            head.next = res.next
            res.next = head
            head = next
            
        return res.next
        
        
    def findMid(self, head):
        slow, fast = head, head
        
        
        while fast and fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            
        return slow