# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()

        while head:
            tmp = head.next
            head.next = result.next
            result.next = head
            head = tmp

        return result.next