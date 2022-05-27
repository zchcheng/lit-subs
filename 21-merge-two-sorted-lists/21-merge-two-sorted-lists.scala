/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
        val res = ListNode()
        var cur = res
        var h1 = list1
        var h2 = list2

        while (h1 != null || h2 != null) {
            val v1 = if (h1 == null) Int.MaxValue else h1.x
            val v2 = if (h2 == null) Int.MaxValue else h2.x

            cur.next = ListNode(v1 min v2)
            
            if (cur.next.x == v1) h1 = h1.next
            else h2 = h2.next

            cur = cur.next
        }

        res.next
    }
}