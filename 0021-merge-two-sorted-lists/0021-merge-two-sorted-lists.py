# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:

        result = ListNode()
        tail = result
        lists = [list1, list2]

        def get_from_list(index: int):
            nonlocal lists
            item = lists[index]
            lists[index] = lists[index].next
            return item

        def set_tail(item: ListNode):
            nonlocal tail
            tail.next = item
            item.next = None
            tail = tail.next

        while lists[0] or lists[1]:
            if not lists[0]:
                set_tail(get_from_list(1))
                continue

            if not lists[1]:
                set_tail(get_from_list(0))
                continue

            if lists[0].val <= lists[1].val:
                set_tail(get_from_list(0))
            else:
                set_tail(get_from_list(1))

        return result.next