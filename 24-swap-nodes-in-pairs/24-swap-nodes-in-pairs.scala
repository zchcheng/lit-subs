/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def swapPairs(head: ListNode): ListNode = {
        val d1: ListNode = ListNode(0, head)
        val d2: ListNode = ListNode(0, d1)

        var first = d1
        var second = d2
        var prev: ListNode = null

        while(first != null && first.next != null && first.next.next != null) {
            prev = first

            first = first.next.next
            second = second.next.next

            val next = first.next

            prev.next = first
            second.next = next
            first.next = second

            second = first
            first = first.next
        }

        d1.next
    }
}