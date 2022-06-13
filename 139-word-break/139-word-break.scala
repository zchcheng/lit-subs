import scala.collection.mutable._

object Solution {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val memo: Map[String, Boolean] = Map()
    helper(s, wordDict, memo)
  }

  def helper(
      s: String,
      dict: List[String],
      memo: Map[String, Boolean]
  ): Boolean = {
    if (s.isEmpty) true
    else if (memo.contains(s)) memo.get(s).get
    else {
      var res = false
      dict.foreach { w =>
        if (s.startsWith(w)) {
          res ||= helper(s.substring(w.length), dict, memo)
        }
      }
      memo += (s -> res)
      res
    }
  }
}