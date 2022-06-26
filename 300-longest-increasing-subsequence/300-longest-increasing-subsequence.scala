import scala.collection.mutable._

object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = {
        val list: ListBuffer[Int] = ListBuffer()

        nums.foreach { num => 
            val i = binSearch(list, num)

            if (i == list.length) list += num
            else list(i) = num
        }

        list.length
    }

    def binSearch(list: ListBuffer[Int], target: Int): Int = {
        var s = 0
        var e = list.length - 1

        while (s <= e) {
            val m = (s + e) / 2
            val v = list(m)

            if (v >= target) {
                e = m - 1
            } else {
                s = m + 1
            }
        }

        s
    }
}