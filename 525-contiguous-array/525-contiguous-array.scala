import scala.collection.mutable._
        
object Solution {
    def findMaxLength(nums: Array[Int]): Int = {
        val map: Map[Int, Int] = Map()
        map += (0 -> -1)

        var cnt = 0
        var res = 0

        nums.zipWithIndex.foreach { case (num, idx) =>
            if (num == 0) cnt -= 1 else cnt += 1
            if (map.contains(cnt)) {
                res = res max idx - map.get(cnt).get
            } else {
                map += (cnt -> idx)
            }
        }

        res 
    }
}