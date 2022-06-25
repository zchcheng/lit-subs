import scala.collection.mutable._

object Solution {
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
      if (n == 1) List(0) 
      else {
          val connect: Array[Set[Int]] = Array.fill(n)(Set())

          edges.foreach { edge =>
              connect(edge(0)) += edge(1)
              connect(edge(1)) += edge(0)
          }

          val queue: Queue[Int] = Queue()
          var left = n

          for (i <- 0 to n - 1) {
              if (connect(i).size == 1) {
                  queue.enqueue(i)
                  left -= 1
              }
          }

          while (left > 0) {
              val size = queue.size
              for (i <- 0 to size - 1) {
                  val e = queue.dequeue
                  connect(e) foreach { c =>
                      connect(c) -= e
                      if (connect(c).size == 1) {
                          queue.enqueue(c)
                          left -= 1
                      }
                  }
              }
          }

          queue.toList
      }
  }
}