import scala.collection.mutable._

object Solution {
  val map: Map[Char, String] = Map(
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz"
  )

  def letterCombinations(digits: String): List[String] = {
    val queue: Queue[String] = Queue()

    if (digits.nonEmpty) queue.enqueue("")

    for (d <- digits) {
      val size = queue.length
      val s = map.get(d).get

      for (i <- 1 to size) {
        var e = queue.dequeue

        for (c <- s) {
          queue.enqueue(e + c)
        }
      }
    }

    queue.toList
  }
}