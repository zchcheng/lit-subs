object Solution {
  def maxArea(height: Array[Int]): Int = {
    var l = 0
    var r = height.length - 1
    var res = 0

    while (l < r) {
      res = res max ((height(l) min height(r)) * (r - l))
      if (height(r) >= height(l)) {
        l += 1
      } else {
        r -= 1
      }
    }

    res
  }
}