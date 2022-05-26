/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var h1 = l1
        var h2 = l2
        var c = 0
        var res = ListNode(0)
        var h = res
        
        while(h1 != null || h2 != null) {
            val v1 = if (h1 == null) 0 else h1.x
            val v2 = if (h2 == null) 0 else h2.x
            val sum = (v1 + v2 +c)
            h.next = ListNode(sum % 10)
            h = h.next
            c = sum / 10
            
            if (h1 != null) h1 = h1.next
            if (h2 != null) h2 = h2.next
        }
        
        if (c != 0) h.next = ListNode(c)
        
        res.next
    }
}