import scala.collection.mutable._

object Solution {
    def longestConsecutive(nums: Array[Int]): Int = {
        val set = nums.toSet
        val map: Map[Int, Int] = Map()

        var res = 0

        set.foreach { n =>
            var l = 1
            var c = n

            while(!map.contains(c + 1) && set.contains(c + 1)) {
                l += 1
                c += 1
            }

            l += map.get(c + 1).getOrElse(0)

            map += (n -> l)

            res = res max l
        }

        res
    }
}