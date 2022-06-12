import scala.collection.mutable._

object Solution {
  def sortColors(nums: Array[Int]): Unit = {
    val cn = Array(0, 0, 0)
    nums.foreach { num => cn(num) += 1 }

    var j = 0
    for (i <- 0 to nums.length - 1) {
      while (cn(j) == 0) j += 1
      cn(j) -= 1
      nums(i) = j
    }
  }
}