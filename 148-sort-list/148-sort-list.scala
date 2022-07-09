object Solution {
    def sortList(head: ListNode): ListNode = {
        mergeSort(head)
    }

    def mergeSort(head: ListNode): ListNode = {

        def merge(head1: ListNode, head2: ListNode): ListNode = {
            val res: ListNode = ListNode()
            var current = res
            var p1 = head1
            var p2 = head2

            while(p1 != null || p2 != null) {
                if (p1 != null && (p2 == null || p1.x <=  p2.x)) {
                    current.next = p1
                    p1 = p1.next
                    current = current.next
                }
                if (p2 != null && (p1 == null || p2.x <= p1.x)) {
                    current.next = p2
                    p2 = p2.next
                    current = current.next
                }
            }

            res.next
        }


        def split(): (ListNode, ListNode) = {
            var fast = head
            var slow = head

            while(fast != null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next
                slow = slow.next
            }

            val tail = slow.next
            slow.next = null

            (head, tail)
        }

        if (head == null || head.next == null) {
            head
        } else {
            val (firstHalf, secondHalf) = split()
            merge(mergeSort(firstHalf), mergeSort(secondHalf))
        }
    }
}