import scala.collection.mutable._

object Solution {
  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if (sum % 2 == 1) false
    else {
      val target = sum / 2
      val memo: Array[Array[Int]] = Array.fill(nums.length) { Array.fill(target + 1)(-1) }
      helper(nums, 0, sum / 2, memo)
    }
  }

  def helper(
      nums: Array[Int],
      idx: Int,
      target: Int,
      memo: Array[Array[Int]]
  ): Boolean = {
    if (target == 0) true
    else if (idx >= nums.length) false
    else if (memo(idx)(target) != -1) memo(idx)(target) == 1
    else {
      val n = nums(idx)
      val take = if (n <= target) helper(nums, idx + 1, target - n, memo) else false
      val noTake = helper(nums, idx + 1, target, memo)
      memo(idx)(target) = if (take) 1 else 0
      take || noTake
    }
  }
}