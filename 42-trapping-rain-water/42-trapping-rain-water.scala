import scala.collection.mutable._

object Solution {
    def trap(height: Array[Int]): Int = {
        val stack: Stack[(Int, Int)] = Stack()
        var res = 0

        height.zipWithIndex.foreach { case (h, idx) =>
            while(stack.nonEmpty && stack.top._2 < h) {
                val (pidx, ph) = stack.pop
                val d = if (stack.isEmpty) 0 else (Math.min(stack.top._2, h) - ph)
                val w = if (stack.isEmpty) 0 else idx - stack.top._1 - 1
                res += d * w
            }

            if (stack.isEmpty || stack.top._2 >= h) stack.push((idx, h))
        }

        res
    }
}