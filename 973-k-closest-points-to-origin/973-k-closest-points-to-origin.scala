import scala.collection.mutable._
object Solution {
    def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
        
        val pq: PriorityQueue[Array[Int]] = PriorityQueue()(Ordering.by { p => p(0) * p(0) + p(1) * p(1) })

        for(p <- points) {
            pq.enqueue(p)
            while(pq.length > k) pq.dequeue
        }

        var res: Array[Array[Int]] = Array()

        while(pq.nonEmpty) {
            res = res :+ pq.dequeue
        }

        res
    }
}