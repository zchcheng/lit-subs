# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        res = ListNode()
        cur = res
        
        carry = 0
        while l1 or l2:
            v1 = 0 if not l1 else l1.val
            v2 = 0 if not l2 else l2.val
            s = carry + v1 + v2
            carry = s // 10
            cur.next = ListNode(s % 10)
            cur = cur.next
            if l1: l1 = l1.next
            if l2: l2 = l2.next
                
        if carry:
            cur.next = ListNode(carry)
        
        return res.next