import scala.collection.mutable._

object Solution {
    def romanToInt(s: String): Int = {
        val map = Map({'I' -> 1}, {'V' -> 5}, {'X' -> 10}, {'L' -> 50}, {'C' -> 100}, {'D' -> 500}, {'M' -> 1000})
        var res = 0
        
        for(i <- 0 to s.length - 1) {
            val prev = if (i == 0) 0 else map(s.charAt(i - 1))
            val cur = map(s.charAt(i))
            
            if (prev * 5 == cur || prev * 10 == cur) {
                res -= 2 * prev
            }
            
            res += cur
        }
        
        res
    }
}