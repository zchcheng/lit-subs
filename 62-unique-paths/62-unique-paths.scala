import scala.collection.mutable._

object Solution {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp: Array[Int] = Array.fill(n) { 1 }

    for (i <- 1 to m - 1) {
      for (j <- 1 to n - 1) {
        dp(j) += dp(j - 1)
      }
    }

    dp(n - 1)
  }
}