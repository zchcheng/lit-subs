import scala.collection.mutable._

object Solution {
    def getFood(grid: Array[Array[Char]]): Int = {
        val queue: Queue[(Int, Int)] = Queue()
        
        val r = grid.length
        val c = grid(0).length
        
        for(i <- 0 to r - 1) {
            for (j <- 0 to c - 1) {
                if (grid(i)(j) == '*') queue.enqueue((i, j))
            }
        }
        
        var len = 0
        var found = false
        
        while(!found && queue.nonEmpty) {
            len += 1
            val size = queue.size
            
            for(i <- 1 to size) {
                val p = queue.dequeue
                Seq((1, 0), (-1, 0), (0, 1), (0, -1)).foreach { move =>
                    val nx = p._1 + move._1
                    val ny = p._2 + move._2
                    
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (grid(nx)(ny) == '#') {
                            found = true
                        } else if (grid(nx)(ny) =='O') {
                            grid(nx)(ny) = 'x'
                            queue.enqueue((nx, ny))
                        }
                    }
                }
            }
        }
        
        if (!found) -1 else len
    }
}