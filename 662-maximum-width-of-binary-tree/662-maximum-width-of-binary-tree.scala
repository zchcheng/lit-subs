import scala.collection.mutable._

          // 1
        // 2   3
      // 4  5 6  7 <-  6 - 3 + 1 = 4

object Solution {
    def widthOfBinaryTree(root: TreeNode): Int = {
        val queue: Queue[(TreeNode, Long)] = Queue()
        var res = 0l

        queue.enqueue((root, 1))

        while(queue.nonEmpty) {
            val size = queue.size

            var min = Long.MaxValue
            var max = Long.MinValue

            for(i <- 1 to size) {
                val (node, offset) = queue.dequeue
                if (node.left != null) queue.enqueue((node.left, offset * 2))
                if (node.right != null) queue.enqueue((node.right, offset * 2 + 1))
                min = offset min min
                max = offset max max
            }

            res = res max (max - min + 1)
        }

        res.asInstanceOf[Int]
    }
}