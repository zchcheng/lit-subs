import scala.collection.mutable._

object Solution {
    def longestPalindrome(s: String): Int = {
        var map: Map[Char, Int] = Map().withDefaultValue(0)
        
        s.foreach { c =>  map(c) = map(c) + 1 }
        
        var res = 0
        
        map.values.foreach { n =>  res += n / 2  }
        
        res * 2 + (if (map.values.map(_ % 2 != 0).reduce(_ || _)) 1 else 0)
    }
}