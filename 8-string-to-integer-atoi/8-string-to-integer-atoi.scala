object Solution {
  def myAtoi(s: String): Int = {
    var cur = 0
    var res = 0

    while (cur < s.length && s.charAt(cur) == ' ') {
      cur += 1
    }

    var isNeg = false
    if (cur < s.length && (s.charAt(cur) == '+' || s.charAt(cur) == '-')) {
      isNeg = s.charAt(cur) == '-'
      cur += 1
    }

    var end = false
    while (!end && cur < s.length) {
      if (!s.charAt(cur).isDigit) { end = true }
      else {
        val v = s.charAt(cur).getNumericValue
        if (res > 0 && isNeg) res *= -1

        if (isNeg && (res < (Int.MinValue) / 10 || (res == Int.MinValue / 10 && v >= 8))) {
          res = Int.MinValue
          end = true
        } else if (!isNeg && (res > Int.MaxValue / 10 || (res == Int.MaxValue / 10 && v >= 7))) {
          res = Int.MaxValue
          end = true
        } else {
          if (isNeg) res = res * 10 - v
          else res = res * 10 + v
        }
        cur += 1
      }
    }

    res
  }
}