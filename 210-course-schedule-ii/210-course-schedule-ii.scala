import scala.collection.mutable._

object Solution {
    def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
        val prereq: Array[Set[Int]] = Array.fill(numCourses)(Set())
        val reqBy: Array[Set[Int]] = Array.fill(numCourses)(Set())

        prerequisites.foreach { pre => 
            prereq(pre(0)).add(pre(1)) 
            reqBy(pre(1)).add(pre(0))
        }

        val queue: Queue[Int] = Queue()

        prereq.zipWithIndex.foreach { case (req, i) => if (req.isEmpty) queue.enqueue(i) }

        val res: ListBuffer[Int] = ListBuffer()

        while(queue.nonEmpty) {
            val n = queue.dequeue
            res += n
            reqBy(n).foreach { c =>
                prereq(c).remove(n)
                if (prereq(c).isEmpty) queue.enqueue(c)
            }
        }

        if (res.size == numCourses) res.toArray else Array[Int]()
    }
}