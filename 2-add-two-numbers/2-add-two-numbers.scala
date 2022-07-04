object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var i = l1
        var j = l2
        var c = 0

        val res = ListNode()
        var head = res

        while(i != null || j != null) {
            val vi = if (i != null) {
                val v = i.x
                i = i.next
                v
            } else 0

            val vj = if (j != null) {
                val v = j.x
                j = j.next
                v
            } else 0

            head.next = ListNode((vi + vj + c) % 10)
            c = (vi + vj + c) / 10

            head = head.next
        }

        if (c != 0) head.next = ListNode(c)

        res.next
    }
}