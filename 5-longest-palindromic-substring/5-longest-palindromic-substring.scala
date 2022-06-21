object Solution {
  def longestPalindrome(s: String): String = {
    var ml = 1
    var res = s.substring(0, 1)

    val dp: Array[Array[Boolean]] = Array.fill(s.length + 1) {
      Array.fill(s.length)(false)
    }

    for (i <- 0 to s.length - 1) {
      for (j <- 0 to s.length - 1) {
        dp(i)(j) =
          (j - i >= 0 && (i < 2 || dp(i - 2)(j - 1)) && s.charAt(j) == s.charAt(j - i))
        if (dp(i)(j) && i >= ml) {
          ml = i + 1
          res = s.substring(j - i, j + 1)
        }
      }
    }

    res
  }
}