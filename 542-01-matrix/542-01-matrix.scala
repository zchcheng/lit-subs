import scala.collection.mutable._

object Solution {
    def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
        val moves = Seq((0, 1), (1, 0), (0, -1), (-1, 0))
        val r = mat.length
        val c = mat(0).length
        val res: Array[Array[Int]] = Array.fill[Array[Int]](r) { Array.fill[Int](c) {-1} }
        val q: Queue[(Int, Int, Int)] = Queue()
        
        for(i <- 0 to r - 1) {
            for(j <- 0 to c - 1) {
                if (mat(i)(j) == 0) {
                    q.enqueue((i, j, 0))
                }
            }
        }
        
        while(!q.isEmpty) {
            val p = q.dequeue
            if (res(p._1)(p._2) == -1) {
                res(p._1)(p._2) = p._3
                
                for(n <- moves) {
                    val nx = n._1 + p._1
                    val ny = n._2 + p._2
                    
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && res(nx)(ny) == -1)  {
                        q.enqueue((nx, ny, p._3 + 1))
                    }
                }
                
            }
        }
        
        res
    }
}