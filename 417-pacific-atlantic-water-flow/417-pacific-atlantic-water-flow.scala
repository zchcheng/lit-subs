import scala.collection.mutable._

object Solution {
    def pacificAtlantic(heightMap: Array[Array[Int]]): List[List[Int]] = {
        val r = heightMap.length
        val c = heightMap(0).length

        val po: Array[Array[Boolean]] = Array.fill(r) { Array.fill(c)(false) }
        val ao: Array[Array[Boolean]] = Array.fill(r) { Array.fill(c)(false) }

        for(i <- 0 to r - 1) {
            po(i)(0) = true
            ao(i)(c - 1) = true
        }

        for(i <- 0 to c - 1) {
            po(0)(i) = true
            ao(r - 1)(i) = true
        }

        fill(po, heightMap)
        fill(ao, heightMap)

        val res: ListBuffer[List[Int]] = ListBuffer()

        for(i <- 0 to r - 1) {
            for(j <- 0 to c - 1) {
                if (po(i)(j) && ao(i)(j)) res += List(i, j)
            }
        }

        res.toList
    }

    def fill(arr: Array[Array[Boolean]], hm: Array[Array[Int]]): Unit = {
        val queue: Queue[(Int, Int)] = Queue()

        val r = arr.length
        val c = arr(0).length

        for(i <- 0 to r - 1) {
            for(j <- 0 to c - 1) {
                if (arr(i)(j)) queue.enqueue((i, j))
            }
        }

        while(queue.nonEmpty) {
            val size = queue.size

            for(i <- 1 to size) {
                val p = queue.dequeue
                val h = hm(p._1)(p._2)

                Seq((1, 0), (-1, 0), (0, 1), (0, -1)).foreach { next => 
                    val nx = p._1 + next._1
                    val ny = p._2 + next._2

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !arr(nx)(ny) && hm(nx)(ny) >= h) {
                        arr(nx)(ny) = true
                        queue.enqueue((nx, ny))
                    }
                }
            }
        }
    }
}