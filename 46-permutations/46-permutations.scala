import scala.collection.mutable._

object Solution {
  def permute(nums: Array[Int]): List[List[Int]] = {
    val set: Set[Int] = Set.from(nums)
    val res: ListBuffer[List[Int]] = ListBuffer()
    helper(set, ListBuffer(), res)
    res.toList
  }

  def helper(
      nums: Set[Int],
      cur: ListBuffer[Int],
      res: ListBuffer[List[Int]]
  ): Unit = {
    if (nums.isEmpty) {
      res += cur.toList
    } else {
      for (n <- nums) {
        cur += n
        val next = nums.filter(_ != n)
        helper(next, cur, res)
        cur.remove(cur.length - 1)
      }
    }
  }
}