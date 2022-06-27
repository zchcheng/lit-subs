object Solution {
    def oddEvenList(head: ListNode): ListNode = {
        val odds = ListNode(0)
        val evens = ListNode(0)
        var oh = odds
        var eh = evens

        var cur = head
        var isOdd = true

        while (cur != null) {
            val next = cur.next

            cur.next = null

            if (isOdd) {
                oh.next = cur
                oh = cur
            } else {
                eh.next = cur
                eh = cur
            }

            cur = next
            isOdd = !isOdd
        }

        oh.next = evens.next

        odds.next
    }
}