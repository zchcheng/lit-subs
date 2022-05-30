/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
        val res = ListNode()
        var cur = head
        
        while(cur != null) {
            val next = cur.next
            
            cur.next = res.next
            res.next = cur
            
            cur = next
        }
        
        res.next
    }
}