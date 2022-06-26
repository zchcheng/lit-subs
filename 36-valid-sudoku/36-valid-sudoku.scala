import scala.collection.mutable._

object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        var res = true

        // check rows
        for (row <- 0 to 8) res &&= checkRow(board, row)

        // check cols
        for (col <- 0 to 8) res &&= checkCol(board, col)

        // check boxes
        for (i <- 0 to 2)
            for (j <- 0 to 2)
                res &&= checkBox(board, i, j)

        res
    }

    def checkRow(board: Array[Array[Char]], row: Int): Boolean = {
        val hashset: Array[Boolean] = Array.fill(9)(false)

        var res = true
        for (col <- 0 to 8) {
            val v = board(row)(col).getNumericValue
            if (v > 0 && v < 10) {
                if (hashset(v - 1)) res = false
                hashset(v - 1) = true
            }
        }

        res
    }

    def checkCol(board: Array[Array[Char]], col: Int): Boolean = {
        val hashset: Array[Boolean] = Array.fill(9)(false)

        var res = true
        for (row <- 0 to 8) {
            val v = board(row)(col).getNumericValue
            if (v > 0 && v < 10) {
                if (hashset(v - 1)) res = false
                hashset(v - 1) = true
            }
        }

        res
    }

    def checkBox(board: Array[Array[Char]], i: Int, j: Int): Boolean = {
        val hashset: Array[Boolean] = Array.fill(9)(false)

        var x = i * 3
        var y = j * 3

        var res = true
        for (nx <- 0 to 2) {
            for (ny <- 0 to 2) {
                val v = board(x + nx)(y + ny).getNumericValue
                if (v > 0 && v < 10) {
                    if (hashset(v - 1)) res = false
                    hashset(v - 1) = true
                }
            }
        }

        res
    }
}