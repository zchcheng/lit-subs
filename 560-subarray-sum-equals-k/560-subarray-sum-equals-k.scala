import scala.collection.mutable._

object Solution {
    def subarraySum(nums: Array[Int], k: Int): Int = {
        val map: Map[Int, Int] = Map()
        var sum = 0
        var res = 0
        
        nums.foreach { n =>
            sum += n
            val diff = sum - k
            res += map.get(diff).getOrElse(0)
            if (sum == k) res += 1
            map += (sum -> (map.get(sum).getOrElse(0) + 1))
        }

        res
    }
}
