import scala.collection.mutable._

object Solution {
  def sortColors(nums: Array[Int]): Unit = {
    var p0 = 0
    var p2 = nums.length - 1
    var cur = 0

    while (cur <= p2) {
      nums(cur) match {
        case 0 => {
          swap(p0, cur, nums)
          p0 += 1
          cur += 1
        }
        case 1 => {
          cur += 1
        }
        case 2 => {
          swap(p2, cur, nums)
          p2 -= 1
        }
      }
    }
  }

  def swap(a: Int, b: Int, nums: Array[Int]): Unit = {
    val tmp = nums(a)
    nums(a) = nums(b)
    nums(b) = tmp
  }
}