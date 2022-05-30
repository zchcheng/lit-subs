import scala.collection.mutable._

object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        var map: Map[Char, Int] = Map().withDefaultValue(0)
        
        magazine.foreach { c => map += {c -> (map(c) + 1)}}
        
        var res = true
        
        ransomNote.foreach { c =>
            if (map(c) > 0) {
                map(c) = map(c) - 1
            } else {
                res = false
            }
        }
        
        res
    }
}