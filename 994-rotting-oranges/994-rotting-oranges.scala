import scala.collection.mutable._

object Solution {
    def orangesRotting(grid: Array[Array[Int]]): Int = {
        val q: Queue[Array[Int]] = Queue()
        var total = 0
        var round = 0
        
        val r = grid.length
        val c = grid(0).length
        
        for(i <- 0 to r - 1) {
            for(j <- 0 to c - 1) {
                grid(i)(j) match {
                    case 1 => total += 1
                    case 2 => q.enqueue(Array(i, j))
                    case _ => 
                }
            }
        }
        
        while(total > 0 && q.nonEmpty) {
            val qs = q.length
            
            for(i <- 0 to qs - 1) {
                val o = q.dequeue
                
                for(n <- Seq((0, 1), (0, -1), (1, 0), (-1, 0))) {
                    val nr = o(0) + n._1
                    val nc = o(1) + n._2
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid(nr)(nc) == 1) {
                        grid(nr)(nc) = 2
                        q.enqueue(Array(nr, nc))
                        total -= 1
                    }
                }
            }
            
            round += 1
        }
        
        if (total == 0) round else -1
    }
}