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
        
        while(h1 != null || h2 != null) {
            val v1 = if (h1 == null) Integer.MAX_VALUE else h1.x
            val v2 = if (h2 == null) Integer.MAX_VALUE else h2.x
            
            cur.next = ListNode(v1 min v2)
            cur = cur.next
            
            if (v1 <= v2) {
                h1 = h1.next
            } else {
                h2 = h2.next
            }
        }
        
        res.next
    }
}