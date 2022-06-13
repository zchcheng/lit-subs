import scala.collection.mutable._

object Solution {
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        val r = matrix.length
        val c = matrix(0).length
        val dirs = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))
        var rowRange: Array[Int] = Array(-1, r)
        var colRange: Array[Int] = Array(-1, c)
        var curDir = 0
        val res: ListBuffer[Int] = ListBuffer()
        var curR = 0
        var curC = 0

        while (res.length < r * c) {
            val dir = dirs(curDir)

            while (
                curR > rowRange(0) && curR < rowRange(1) && curC > colRange(0) && curC < colRange(1)
            ) {
                res += matrix(curR)(curC)
                curR += dir(0)
                curC += dir(1)
            }

            curR -= dir(0)
            curC -= dir(1)

            curDir = (curDir + 1) % 4
            val nextDir = dirs(curDir)

            curR += nextDir(0)
            curC += nextDir(1)

            rowRange(0) = Math.max(rowRange(0), rowRange(0) + nextDir(0))
            rowRange(1) = Math.min(rowRange(1), rowRange(1) + nextDir(0))
            colRange(0) = Math.max(colRange(0), colRange(0) + nextDir(1))
            colRange(1) = Math.min(colRange(1), colRange(1) + nextDir(1))
        }

        res.toList
    }
}