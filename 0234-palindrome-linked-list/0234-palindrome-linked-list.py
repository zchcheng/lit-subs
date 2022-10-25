# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast = head
        slow = head
        
        while fast and fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            
        mid = slow.next
        slow.next = None
        
        rh = self.reverse(mid)
        
        while rh and head:
            if rh.val != head.val:
                return False
            rh = rh.next
            head = head.next
            
        return True
        
    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
        r = ListNode()
        cur = r
        
        while head:
            n = head.next
            head.next = r.next
            cur.next = head
            head = n
            
        return r.next