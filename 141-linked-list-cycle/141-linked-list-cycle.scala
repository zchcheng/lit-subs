/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def hasCycle(head: ListNode): Boolean = {
        var slow = head
        var fast = head
        var res = false
        
        while(fast != null && fast.next != null && !res) {
            slow = slow.next
            fast = fast.next.next
            res = slow == fast
        }
        
        res
    }
}