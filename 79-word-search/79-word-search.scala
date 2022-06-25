import scala.collection.mutable._

object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
      var found = false
      for(i <- 0 to board.length - 1)
        for (j <- 0 to board(0).length - 1) 
            found ||= helper(board, Set(), word, 0, (i, j))
      found
  }

  def helper(
      board: Array[Array[Char]],
      visited: Set[(Int, Int)],
      word: String,
      i: Int,
      pos: (Int, Int)
  ): Boolean = {
    if (i >= word.length) true
    else {
      val c = word.charAt(i)

      if (c != board(pos._1)(pos._2)) false
      else if (i == word.length - 1) true
      else {
        var wordFound = false

        visited += pos

        val moves = Seq((1, 0), (0, 1), (-1, 0), (0, -1))
        var j = 0

        while (!wordFound && j < 4) {
          val move = moves(j)
          val next = ((pos._1 + move._1), (pos._2 + move._2))
          if (
            !(next._1 < 0 || next._1 >= board.length || next._2 < 0 || next._2 >= board(
              0
            ).length || visited.contains(next))
          ) {
            wordFound = helper(board, visited, word, i + 1, next)
          }
          j += 1
        }

        visited -= pos
        wordFound
      }
    }
  }
}