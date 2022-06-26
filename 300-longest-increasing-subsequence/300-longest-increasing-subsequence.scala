import scala.collection.mutable._

object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = {
        val list: ListBuffer[Int] = ListBuffer()

        nums.foreach { num => 
            var i = list.length - 1

            while (i >= 0 && list(i) >= num) i -= 1
            
            if (i == list.length - 1) list += num
            else list(i + 1) = num
        }

        list.length
    }
}