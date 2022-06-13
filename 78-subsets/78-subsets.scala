import scala.collection.mutable._

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val res: ListBuffer[List[Int]] = ListBuffer()
    helper(nums, 0, ListBuffer(), res)
    res.toList
  }

  def helper(
      nums: Array[Int],
      idx: Int,
      current: ListBuffer[Int],
      res: ListBuffer[List[Int]]
  ): Unit = {
    if (idx >= nums.length) {
      res += current.toList
    } else {
      // not take
      helper(nums, idx + 1, current, res)

      // take
      current += nums(idx)
      helper(nums, idx + 1, current, res)
      current.remove(current.length - 1)
    }
  }
}