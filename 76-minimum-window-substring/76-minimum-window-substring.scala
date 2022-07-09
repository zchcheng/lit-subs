import scala.collection.mutable._

object Solution {
    def minWindow(s: String, t: String): String = {
        val set: Set[Char] = Set()
        val map: Map[Char, Int] = Map()

        t.foreach { c =>
            set += c
            map += (c -> (map.get(c).getOrElse(0) + 1))
        }
        
        var res = (-100000, 100000)
        var lack = set.size
        var head = 0
        var tail = -1

        while (head < s.length) {
            val c = s.charAt(head)

            if (set.contains(c)) {
                map += (c -> (map.get(c).getOrElse(0) - 1))
                if (map.get(c).getOrElse(0) == 0) {
                    lack -= 1
                }
            }

            while(lack == 0 && tail < head) {
                tail += 1

                if (res._2 - res._1 > head - tail) {
                    res = (tail, head)
                }

                val rc = s.charAt(tail)
                if (set.contains(rc)) {
                    map += (rc -> (map.get(rc).getOrElse(0) + 1))
                    if (map.get(rc).getOrElse(0) == 1) {
                        lack += 1
                    }
                }
            }

            head += 1
        }

        if (res._1 < 0 || res._2 < 0) ""
        else s.subSequence(res._1, res._2 + 1).toString
    }
}