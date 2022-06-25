import scala.collection.mutable._
object Solution {
    def leastInterval(tasks: Array[Char], n: Int): Int = {
        val bucket: Map[Char, Int] = Map()
        var m = 0
        var s = 0

        tasks.foreach { task =>
            val num = bucket.get(task).getOrElse(0) + 1
            
            bucket += (task -> num)
            if (num == m)  s += 1
            else if (num > m) { 
                m = num
                s = 1
            }
        }

        ((n + 1) * (m - 1) + 1) + (s - 1) max tasks.length
    }
}