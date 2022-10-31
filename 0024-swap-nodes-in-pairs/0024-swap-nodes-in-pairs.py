# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode(0, head)
        ptr = result
        
        while ptr and ptr.next and ptr.next.next:
            nn = ptr.next
            nnn = ptr.next.next
            
            ptr.next = nnn
            nn.next = nnn.next
            nnn.next = nn
            
            ptr = nn
        
        return result.next