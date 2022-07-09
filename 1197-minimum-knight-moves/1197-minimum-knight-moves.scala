import scala.collection.mutable._

object Solution {
    def minKnightMoves(x: Int, y: Int): Int = {
      val moves = Seq((2, 1), (1, 2), (-1, 2), (-2, 1), (1, -2), (2, -1), (-2, -1), (-1, -2))

      val queue: Queue[(Int, Int)] = Queue()
      val visited: Set[(Int, Int)] = Set()

      queue.enqueue((0, 0))

      var res = 0
      var reach = false

      while(!reach && queue.nonEmpty) {
        val size = queue.size
        for(i <- 1 to size) {
          val (cx, cy) = queue.dequeue
          reach = reach || (cx == x && cy == y)

          moves.foreach { move =>
            val nx = cx + move._1
            val ny = cy + move._2
            if (!visited.contains((nx, ny))) {
              queue.enqueue((nx, ny))
              visited += ((nx, ny))
            }
          }
        }
        if (!reach) res += 1
      }

      res
    }
}