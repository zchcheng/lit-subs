import scala.collection.mutable._

object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = {
        val dp: Array[Int] = Array.fill(nums.length)(1)
        var res = 0

        for(i <- 0 to nums.length - 1) {
            var tmp = 1
            val v = nums(i)

            for(j <- 0 to i) {
                if (nums(j) < v) tmp = tmp max (1 + dp(j))
            }

            dp(i) = tmp
            res = res max tmp
        }

        res
    }
}