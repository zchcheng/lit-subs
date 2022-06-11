import scala.collection.mutable._

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var res = 0
        var p = -1
        val map: Map[Char, Int] = Map()
        
        for(i <- 0 to s.length - 1) {
            val c = s.charAt(i)
            p = Math.max(p, map.get(c).getOrElse(-1))
            res = Math.max(res, i - p)
            map += (c -> i)
        }
        
        res
    }
}