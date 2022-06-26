object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        var d = new ListNode(0)
        d.next = head

        var fast = d
        for(i <- 1 to n) {
            fast = fast.next
        }

        var slow = d
        var prev: ListNode = null

        while(fast != null) {
            prev = slow
            slow = slow.next
            fast = fast.next
        }

        prev.next = slow.next
        d.next
    }
}