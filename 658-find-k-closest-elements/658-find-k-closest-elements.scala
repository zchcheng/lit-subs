import scala.collection.mutable._

object Solution {
    def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
        if (k >= arr.length) arr.toList
        else {
            val index = binSearch(arr, x)
            
            var i = index
            var j = index + 1

            for(l <- 1 to k) {
                if (i < 0) j += 1
                else if (j == arr.length) i -= 1
                else if (isCloserThan(x, arr(i), arr(j))) i -= 1
                else j += 1
            }
            
            arr.slice(i + 1, j).toList
        }
    }

    private def isCloserThan(target: Int, i: Int, j: Int): Boolean = {
        val di = Math.abs(i - target)
        val dj = Math.abs(j - target)
        if (di < dj || (di == dj && i <= j)) true else false
    }

    private def binSearch(arr: Array[Int], x: Int): Int = {
        var start = 0
        var end = arr.length - 1

        while(start <= end) {
            val mid = (start + end) / 2
            val v = arr(mid)

            if (x < v) end = mid - 1
            else if (x >= v) start = mid + 1
        }

        end
    }
}